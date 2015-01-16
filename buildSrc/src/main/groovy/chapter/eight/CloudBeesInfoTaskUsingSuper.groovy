package chapter.eight

import chapter.eight.mock.PlatformAsAService
import org.gradle.api.tasks.Input

/**
 * Custom task to print out CloudBees application info
 */
class CloudBeesInfoTaskUsingSuper extends CloudBeesTask {

    @Input
    String appId

    CloudBeesInfoTaskUsingSuper() {
        super("Get CloudBees App information using custom task")
    }

    @Override
    void executeAction(PlatformAsAService paas) {
        paas.applicationInfo(appId).each { k, v -> println "$k = $v" }
    }
}
