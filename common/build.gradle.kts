import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "0.3.1"
    id("com.android.library")
    id("kotlin-android-extensions")
}

group = "me.cyberdie22"
version = "1.0.0"

repositories {
    google()
}

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                implementation("com.arkivanov.decompose:decompose:0.2.4")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.appcompat:appcompat:1.2.0")
                api("androidx.core:core-ktx:1.3.1")
                implementation("com.arkivanov.decompose:extensions-android:0.2.4")
                implementation("com.arkivanov.decompose:extensions-compose-jetpack:0.2.4")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13")
            }
        }
        val desktopMain by getting {
            dependencies {
                implementation("com.arkivanov.decompose:extensions-compose-jetbrains:0.2.4")
            }
        }
        val desktopTest by getting
        val composeMain by creating {
            dependsOn(commonMain)
            androidMain.dependsOn(this)
            desktopMain.dependsOn(this)
        }
        val composeTest by creating {
            dependsOn(commonTest)
            androidTest.dependsOn(this)
            desktopTest.dependsOn(this)
        }
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(30)
        targetSdkVersion(30)
    }
}