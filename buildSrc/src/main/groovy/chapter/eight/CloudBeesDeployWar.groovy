package chapter.eight

import chapter.eight.mock.PlatformAsAService
import org.gradle.api.tasks.Input

/**
 * Created by Kevin Suen on 1/20/2015.
 */
class CloudBeesDeployWar extends CloudBeesTask {
    @Input
    String appId

    CloudBeesDeployWar() {
        super('Deploy application to CloudBees using CloudBeesTask')
    }

    @Override
    void executeAction(PlatformAsAService paas) {
        paas.applicationDeployWar(getAppId())
    }
}
