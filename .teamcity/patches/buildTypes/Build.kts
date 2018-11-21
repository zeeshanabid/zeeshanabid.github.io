package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_1.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Build'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Build")) {
    expectSteps {
        script {
            name = "List files"
            scriptContent = "ls -ltrha"
        }
    }
    steps {
        update<ScriptBuildStep>(0) {
            name = "Update git submodules"
            scriptContent = "git submodule update --init"
        }
        insert(1) {
            dockerCommand {
                commandType = build {
                    source = path {
                        path = "./Dockerfile"
                    }
                    contextDir = "."
                    namesAndTags = "dkr.zteche.com/blog:latest"
                    commandArgs = "--pull"
                }
            }
        }
    }
}
