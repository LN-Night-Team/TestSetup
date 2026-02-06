plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.android.lint)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.compose)
}

kotlin {
    androidLibrary {
        namespace = "com.example.shared"
        compileSdk = 36
        minSdk = 35
    }

    val xcfName = "sharedKit"
    iosX64 { binaries.framework { baseName = xcfName } }
    iosArm64 { binaries.framework { baseName = xcfName } }
    iosSimulatorArm64 { binaries.framework { baseName = xcfName } }

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)

                // Compose Multiplatform
                implementation(libs.runtime)
                implementation(libs.foundation)
                implementation(libs.material3)
                implementation(libs.ui)
                implementation(libs.components.resources)

                // Navigation 3 & Lifecycle
                implementation(libs.lifecycle.viewmodel)
                implementation(libs.lifecycle.runtime)
                implementation(libs.lifecycle.runtime.compose)

                // Serialization & Network
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.serialization.core)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)

                // DI
                implementation(libs.koin.core)
                implementation(libs.koin.compose)

                //Coil
                implementation(libs.coil.compose)
                implementation(libs.coil.network.ktor)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.androidx.navigation3.runtime)
                implementation(libs.androidx.navigation3.ui)
                implementation(libs.ktor.client.okhttp)
                implementation(libs.koin.android)
                implementation(libs.koin.androidx.compose)
                implementation(libs.androidx.activity.compose)
                implementation(libs.androidx.core.ktx)
                implementation(libs.androidx.lifecycle.viewmodel.navigation3)
                implementation(libs.androidx.material3.adaptive.navigation3)
            }
        }

        iosMain {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}