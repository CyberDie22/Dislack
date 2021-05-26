plugins {
    id("org.jetbrains.compose") version "0.3.1"
    id("com.android.application")
    kotlin("android")
}

group = "me.cyberdie22"
version = "1.0.0"

repositories {
    google()
}

dependencies {
    implementation(project(":common"))
    implementation("androidx.activity:activity-compose:1.3.0-alpha03")
    implementation("com.arkivanov.decompose:decompose:0.2.4")
    implementation("com.arkivanov.decompose:extensions-compose-jetpack:0.2.4")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "me.cyberdie22.android"
        minSdkVersion(30)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}