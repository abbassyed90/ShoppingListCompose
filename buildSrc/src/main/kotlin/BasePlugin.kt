import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType

class BasePlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target.plugins) {
            apply(Plugins.android_application)
            apply(Plugins.kotlin_android)
        }

        target.extensions.getByType(BaseExtension::class).apply {
            compileSdkVersion(30)
            buildToolsVersion("30.0.3")

            defaultConfig {
                applicationId = "com.abbas.compose.shoppinglist"
                targetSdkVersion(30)
                minSdkVersion(23)

                versionCode = 1
                versionName = "1.0.0"

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                vectorDrawables {
                    useSupportLibrary = true
                }
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
        }

        target.dependencies.apply {
            add("testImplementation", Libraries.JUnit.junit)
        }
    }
}

fun Project.enableCompose() {
    extensions.getByType(BaseExtension::class).apply {
        composeOptions {
            kotlinCompilerExtensionVersion = Libraries.Compose.version
            kotlinCompilerVersion = Libraries.Kotlin.version
        }
        buildFeatures.compose = true
    }
}