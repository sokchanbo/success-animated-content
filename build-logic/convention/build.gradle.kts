plugins {
    `kotlin-dsl`
}

group = "com.chanbo.successanimatedcontent.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "successanimatedcontent.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "successanimtedcontent.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
    }
}