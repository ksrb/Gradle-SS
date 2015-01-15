package chapter.eight

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input

/**
 * Created by Kevin Suen on 1/15/2015.
 */
class CloudBeesTask extends DefaultTask {
    @Input
    String apiFormat = 'xml';
    @Input
    String apiVersion = '1.0';
    @Input
    String apiURl = 'www.cloudbees.com'
    @Input
    String secret
    @Input
    String key

    CloudBeesTask(String description) {
        this.description = description
        group = 'CloudBees'
    }

}
