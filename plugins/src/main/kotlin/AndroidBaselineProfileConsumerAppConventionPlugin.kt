import androidx.baselineprofile.gradle.consumer.BaselineProfileConsumerExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * Convention plugin for consuming baseline profiles in an Android application module.
 *
 * Unlike [AndroidBaselineProfileConsumerLibraryConventionPlugin] (which works around the
 * KMP library plugin not exposing a `LibraryExtension`), an application module can use the
 * stock `androidx.baselineprofile` plugin directly. This convention centralizes applying
 * that plugin and the shared consumer configuration so that consuming projects don't need
 * to declare the `androidx.baselineprofile` plugin — and its version — themselves.
 *
 * Apply this alongside the android application plugin(s):
 * ```kotlin
 * plugins {
 *     id("com.embarrasdf.gradle.plugin.android.application")
 *     id("com.embarrasdf.gradle.plugin.android.baselineprofile.consumer.app")
 * }
 *
 * dependencies {
 *     baselineProfile(projects.app.baselineProfile)
 * }
 * ```
 */
class AndroidBaselineProfileConsumerAppConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("androidx.baselineprofile")

            extensions.configure<BaselineProfileConsumerExtension> {
                // Automatically save generated profiles to src/release/generated/baselineProfiles/
                saveInSrc = true
            }
        }
    }
}
