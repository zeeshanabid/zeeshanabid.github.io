package patches.projects

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project
import jetbrains.buildServer.configs.kotlin.v2018_1.projectFeatures.dockerRegistry
import jetbrains.buildServer.configs.kotlin.v2018_1.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the root project
accordingly, and delete the patch script.
*/
changeProject(DslContext.projectId) {
    features {
        add {
            dockerRegistry {
                id = "PROJECT_EXT_2"
                name = "ZTECHE DKR"
                url = "https://dkr.zteche.com"
                userName = "admin"
                password = "credentialsJSON:a3b246d9-7df6-40a9-bba7-0c01922c996a"
            }
        }
    }
}
