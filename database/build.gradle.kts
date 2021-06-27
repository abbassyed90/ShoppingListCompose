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

dependencies {
    implementation(Libraries.Room.room_runtime)
    implementation(Libraries.Room.room_ktx)
}