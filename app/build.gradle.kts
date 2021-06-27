plugins {
    id(Plugins.android_application)
    id(Plugins.kotlin_android)
    id("grocery-base-module")
}

android {
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
}

setApplicationId()
enableCompose()

dependencies {
    implementation(Libraries.AndroidX.core_ktx)
    implementation(Libraries.AndroidX.app_compat)
    implementation(Libraries.Compose.ui)
    implementation(Libraries.Compose.material)
    implementation(Libraries.Compose.tooling)
    implementation(Libraries.AndroidX.activity_compose)

    implementation(Libraries.Material.material)
    implementation(Libraries.AndroidX.lifecycle_runtime_ktx)

    implementation(project(":theme"))
    implementation(project(":home"))
    implementation(project(":common"))
}