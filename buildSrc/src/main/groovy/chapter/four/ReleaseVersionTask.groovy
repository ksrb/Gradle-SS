package chapter.four

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*

class ReleaseVersionTask extends DefaultTask {
    @Input
    Boolean release
    @OutputFile
    File destFile

    ReleaseVersionTask() {
        group = 'versioning'
        description = 'Custom task to make a release version'
    }

    @TaskAction
    void start() {
        project.versionClass.release = true
        ant.propertyfile(file: destFile) {
            entry(key: 'release', type: 'string', operation: '=', value: 'true')
        }
    }
}