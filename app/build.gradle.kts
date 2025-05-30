plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kapt) // Para Room compiler
    // Quitar el plugin compose
    // id("org.jetbrains.kotlin.plugin.compose") version "1.5.13"
}

android {
    namespace = "com.example.fisiocare"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.fisiocare"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
        // compose = true  // Quitar Compose
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Material Design
    implementation(libs.material)

    // Navigation Component clásico (fragment + ui)
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")

    // Room para persistencia
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")

    // Fragment KTX para extensiones Kotlin
    implementation("androidx.fragment:fragment-ktx:1.8.6")

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Quitar dependencias de Jetpack Compose
    // implementation("androidx.activity:activity-compose:1.9.0")
    // implementation("androidx.compose.ui:ui:1.6.7")
    // implementation("androidx.compose.ui:ui-tooling-preview:1.6.7")
    // implementation("androidx.compose.runtime:runtime:1.6.7")
    // implementation("androidx.compose.material3:material3:1.2.1")
    // debugImplementation("androidx.compose.ui:ui-tooling:1.6.7")
}
