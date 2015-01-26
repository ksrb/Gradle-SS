package chapter.eight

import chapter.eight.mock.CloudBees
import chapter.eight.mock.PlatformAsAService;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

/**
 * Custom task to print out CloudBees application info
 */
class CloudBeesAppInfoTask extends DefaultTask {

    //Passed in by consuming {@link Task}
    @Input
    String appId
    @Input
    String key
    @Input
    String secret

    //Defaults
    @Input
    String url = 'www.cloudbees.com'
    @Input
    int version = 1.0
    @Input
    String format = 'xml'


    CloudBeesAppInfoTask() {
        description = 'Get CloudBees App information using custom task'
        group = 'CloudBees'
    }

    @TaskAction
    void start() {
        PlatformAsAService client = new CloudBees(
                [
                        url    : url,
                        key    : key,
                        secret : secret,
                        version: version,
                        format : format
                ]
        )
        client.applicationInfo(appId).each { k, v -> println "$k = $v" }
    }
}
