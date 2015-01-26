package chapter.eight

import chapter.eight.mock.PlatformAsAService
import org.gradle.api.tasks.Input

/**
 * Created by Kevin Suen on 1/19/2015.
 */
class CloudBeesAppInfoTaskException extends CloudBeesTask {
    @Input
    String appId

    CloudBeesAppInfoTaskException() {
        super('Exception test')
    }

    @Override
    void executeAction(PlatformAsAService paas) {
        throw new Exception('Exception Test')
    }
}
