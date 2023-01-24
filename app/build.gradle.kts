@file:Suppress("UnstableApiUsage")

import com.chanbo.successanimatedcontent.Configuration

plugins {
    id("successanimatedcontent.application.compose")
}

android {
    namespace = "com.chanbo.successanimatedcontentdemo"
    compileSdk = Configuration.compileSdk

    defaultConfig {
        applicationId = "com.chanbo.successanimatedcontentdemo"
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

}

dependencies {
    implementation(project(":success-animated-content"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material)
}