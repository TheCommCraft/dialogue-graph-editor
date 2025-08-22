import java.net.URI

plugins {
    kotlin("multiplatform") version "2.2.10"
}

kotlin {
    js(IR) {
        browser {
            binaries.executable()
        }
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
                implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.11.0")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-web:2025.8.15")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-browser:2025.8.15")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.10.2")
            }
        }
    }
}

repositories {
    mavenCentral()
}
