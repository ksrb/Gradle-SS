package chapter.eight

import chapter.eight.mock.CloudBees
import chapter.eight.mock.PlatformAsAService
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

/**
 * Bootstrap {@link CloudBees} initialization
 * <p>
 * Override {@link CloudBeesTask#executeAction(chapter.eight.mock.PlatformAsAService)} to utilize {@link CloudBees} api
 */
abstract class CloudBeesTask extends DefaultTask {

    //Passed in by consuming {@link Task}
    @Input
    String secret
    @Input
    String key

    //Defaults
    @Input
    String format = 'xml';
    @Input
    int version = 1.0;
    @Input
    String url = 'www.cloudbees.com'


    CloudBeesTask(String description) {
        this.description = description
        group = 'CloudBees'
    }

    @TaskAction
    void start() {
        try {
            PlatformAsAService cloudBees = new CloudBees(
                    [
                            secret : secret,
                            key    : key,
                            format : format,
                            version: version,
                            url    : url,
                    ]
            )
            executeAction(cloudBees)
        } catch (Exception e) {
            throw new GradleException(e.toString());
        }
    }

    abstract void executeAction(PlatformAsAService paas)

}
