plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("ModulePlugin") {
            id = "grocery-base-module"
            implementationClass = "BasePlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())

    implementation("com.android.tools.build:gradle:4.2.1")
    implementation(kotlin("gradle-plugin", "1.5.10"))
    implementation(kotlin("android-extensions"))
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.35")

}