package chapter.eight;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

class CloudBeesInfoTask extends DefaultTask {

    @Input
    String appId, url, key, secret, version, format

    CloudBeesInfoTask() {
        description = 'Get CloudBees App information using custom task'
        group = 'CloudBees'
    }

    @TaskAction
    void start() {
        PlatformAsAService client = new CloudBees(
                [
                        appId  : appId,
                        url    : url,
                        key    : key,
                        secret : secret,
                        version: version,
                        format : format
                ]
        )
        client.applicationInfo().each { k, v -> println "$k = $v" }
    }
}
