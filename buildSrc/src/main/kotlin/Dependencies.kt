
object Libraries {

    object Kotlin {
        const val version = "1.5.10"
    }

    object Compose {
        const val version = "1.0.0-beta09"

        const val ui = "androidx.compose.ui:ui:${version}"
        const val material = "androidx.compose.material:material:${version}"
        const val tooling = "androidx.compose.ui:ui-tooling:${version}"
    }

    object AndroidX {
        const val core_ktx = "androidx.core:core-ktx:1.5.0"
        const val app_compat = "androidx.appcompat:appcompat:1.3.0"
        const val lifecycle_runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
        const val activity_compose = "androidx.activity:activity-compose:1.3.0-beta02"
    }

    object Material {
        const val material = "com.google.android.material:material:1.3.0"
    }

    object JUnit {
        const val junit = "junit:junit:4.13.2"
    }

    object Hilt {
        const val version = "2.35"

        const val hilt = "com.google.dagger:hilt-android:${Libraries.Hilt.version}"
        const val hilt_compiler = "com.google.dagger:hilt-android-compiler:${Libraries.Hilt.version}"
    }

    object Room {
        const val version = "2.3.0-alpha02"

        const val room_runtime = "androidx.room:room-runtime:$version"
        const val room_ktx = "androidx.room:room-ktx:$version"
    }

}