enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Artes"
include(
    ":app-android",
    ":app-desktop",
//    ":app-ios",
    ":app-shared"
)

include(
    ":core-data",
    ":core-ui",
    ":core-entities",
)

include(
    ":feature-text-chat",
)

include(
    ":services:open-ai"
)
