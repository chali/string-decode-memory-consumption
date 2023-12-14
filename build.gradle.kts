plugins {
    alias(libs.plugins.jvm)
    java
}

repositories {
    mavenCentral()
}

dependencies {
    // This dependency is used by the application.
    implementation(libs.springCore)
    implementation(libs.reactive)
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use Kotlin Test test framework
            useKotlinTest("1.9.20")
        }
    }
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}