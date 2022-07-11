
include(
    ":lib_module_1",
    ":lib_module_2",
)

rootProject.name = "Dokka playground"
rootProject.buildFileName = "build.gradle.kts"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = uri("https://nexus.scanbot.io/nexus/content/repositories/snapshots/") }
    }
}
