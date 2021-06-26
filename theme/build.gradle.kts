plugins {
    id(Plugins.android_library)
    id(Plugins.kotlin_android)
    id("grocery-base-module")
}

enableCompose()

android {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Libraries.AndroidX.core_ktx)
    implementation(Libraries.AndroidX.app_compat)
    implementation(Libraries.Compose.ui)
    implementation(Libraries.Compose.material)
    implementation(Libraries.Compose.tooling)
}