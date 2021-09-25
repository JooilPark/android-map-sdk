plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(30)

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    defaultConfig {
        applicationId = "com.naver.maps.map.demo"
        minSdkVersion(15)
        targetSdkVersion(30)
        versionCode = 3120000
        versionName = "3.12.0"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("debug") {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"))
        }
        getByName("release") {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"))
            isMinifyEnabled = true
        }
    }
}

repositories {
    maven("https://google.bintray.com/flexbox-layout")
}

dependencies {
    implementation(kotlin("stdlib-jdk7:1.5.0"))
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation ("com.google.android.flexbox:flexbox:3.0.0")
    implementation("com.google.android.gms:play-services-location:18.0.0")

    implementation("com.naver.maps:map-sdk:3.12.0")
}
