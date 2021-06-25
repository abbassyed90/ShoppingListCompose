plugins {
    id("grocery-base-module")
}

android {
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
}

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
}