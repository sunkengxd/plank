@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    id("maven-publish")
    kotlin("android")
}

android {
    namespace = "com.kamui.plank.fun"
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

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
//                groupId = "com.github.sunkengxd"
//                artifactId = "plank-seal"
//                version = "1.0"

                from(components["release"])
            }
        }
    }
}
