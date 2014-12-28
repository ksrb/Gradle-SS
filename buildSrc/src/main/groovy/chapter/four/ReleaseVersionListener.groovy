package chapter.four

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionGraph
import org.gradle.api.execution.TaskExecutionGraphListener

class ReleaseVersionListener implements TaskExecutionGraphListener {
    private final String releaseTaskPath = ':releaseUsingExecutionGraphListener'

    @Override
    void graphPopulated(TaskExecutionGraph graph) {
        Task releaseTask = graph.allTasks.find({ it.path == releaseTaskPath })
        if (releaseTask) {
            Project project = releaseTask.project
            if (!project.versionClass.release) {
                project.versionClass.release = true
                project.ant.propertyfile(file: project.versionFile) {
                    entry(key: 'release', type: 'string', operation: '=', value: 'true')
                }
            }
        }
    }
}