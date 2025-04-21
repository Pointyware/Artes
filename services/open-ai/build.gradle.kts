/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.kotlinxKover)
}

kotlin {
    jvmToolchain(17)

    jvm("desktop")

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.coreData)

                implementation(libs.koin.core)
                implementation(libs.koin.coroutines)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.kotlinx.coroutinesTest)
            }
        }
    }
}
