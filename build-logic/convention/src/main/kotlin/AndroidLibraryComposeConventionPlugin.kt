import com.android.build.gradle.LibraryExtension
import com.chanbo.successanimatedcontent.configureAndroidCompose
import com.chanbo.successanimatedcontent.configureKotlinAndroid
import com.chanbo.successanimatedcontent.kotlinOptions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")
            pluginManager.apply("org.jetbrains.kotlin.android")

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                configureAndroidCompose(this)

                kotlinOptions {
                    freeCompilerArgs = freeCompilerArgs + listOf("-Xexplicit-api=strict")
                }
            }
        }
    }
}
