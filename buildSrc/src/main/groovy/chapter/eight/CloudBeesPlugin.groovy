package chapter.eight

import org.gradle.api.Plugin
import org.gradle.api.Project


/**
 * Created by Kevin Suen on 1/20/2015.
 */
class CloudBeesPlugin implements Plugin<Project> {
    static final String EXTENSION_NAME = 'cloudBees'

    @Override
    void apply(Project project) {
        project.extensions.create(EXTENSION_NAME, CloudBeesPluginExtension)
        addTasks(project)
    }

    private void addTasks(Project project) {
        project.tasks.withType(CloudBeesTask) {
            def extension = project.extensions.findByName(EXTENSION_NAME)
            conventionMapping.secret = { extension.secret }
            conventionMapping.key = { extension.key }
        }
        addAppTasks(project)
    }

    private void addAppTasks(Project project) {
        project.task('cloudBeesAppInfoWithPlugin', type: CloudBeesAppInfoTaskUsingSuper) {
            conventionMapping.appId = { getAppId(project) }
        }
        project.task('cloudBeesDeployWarWithPlugin', type: CloudBeesDeployWar) {
            conventionMapping.appId = { getAppId(project) }
        }
    }

    private String getAppId(Project project) {
        project.hasProperty('appId') ? project.appId : project.extensions.findByName(EXTENSION_NAME).appId
    }
}
