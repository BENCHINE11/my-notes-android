plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.mynotes"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.mynotes"
        minSdk = 24
        targetSdk = 36
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    compileOnly("org.projectlombok:lombok:1.18.38") // Add Lombok for compilation
    annotationProcessor("org.projectlombok:lombok:1.18.38") // Enable annotation processing
    testCompileOnly("org.projectlombok:lombok:1.18.38") // For test sources
    testAnnotationProcessor("org.projectlombok:lombok:1.18.38")
}