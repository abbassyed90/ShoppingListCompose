import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class BasePlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply(Plugins.kotlin_kapt)
        target.plugins.apply(Plugins.hilt)

        target.extensions.getByType(BaseExtension::class).apply {
            compileSdkVersion(30)
            buildToolsVersion("30.0.3")

            defaultConfig {
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

            add("implementation",Libraries.Hilt.hilt)
            add("kapt",Libraries.Hilt.hilt_compiler)

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

fun Project.setApplicationId() {
    extensions.getByType(BaseExtension::class).apply {
        defaultConfig {
            applicationId = "com.abbas.compose.shoppinglist"
        }
    }
}