@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    id("maven-publish")
    kotlin("android")
}

android {
    namespace = "com.kamui.plank.classic"
    compileSdk = 33

    defaultConfig {
        minSdk = 16

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xcontext-receivers")
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

dependencies.implementation("androidx.core:core-ktx:1.10.0")
