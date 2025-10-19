import com.alexrdclement.gradle.plugin.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltTestFixturesConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
                apply("dagger.hilt.android.plugin")
            }

            dependencies {
                add("implementation", libs.findLibrary("hilt.android").get())
                add("implementation", libs.findLibrary("hilt.android.testing").get())
                add("ksp", libs.findLibrary("hilt.compiler").get())
            }
        }
    }
}
