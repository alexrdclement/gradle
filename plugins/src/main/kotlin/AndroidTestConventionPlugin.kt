import com.alexrdclement.gradle.plugin.AndroidMinSdk
import com.alexrdclement.gradle.plugin.AndroidTargetSdk
import com.alexrdclement.gradle.plugin.configureKotlinAndroid
import com.android.build.gradle.TestExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.test")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<TestExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = AndroidTargetSdk
                defaultConfig.minSdk = AndroidMinSdk
            }
        }
    }
}
