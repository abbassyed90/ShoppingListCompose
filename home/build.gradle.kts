plugins {
    id(Plugins.android_library)
    id(Plugins.kotlin_android)
    id("grocery-base-module")
}

android {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

enableCompose()

dependencies {
    implementation(Libraries.AndroidX.core_ktx)
    implementation(Libraries.AndroidX.app_compat)
    implementation(Libraries.Material.material)

    implementation(Libraries.Compose.ui)
    implementation(Libraries.Compose.material)
    implementation(Libraries.Compose.tooling)

    implementation(project(":common"))
}