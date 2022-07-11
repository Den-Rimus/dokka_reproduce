
buildscript {
   repositories {
      google()
      mavenCentral()
   }
   dependencies {
      classpath("com.android.tools.build:gradle:4.2.2")
      classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
   }
}

plugins {
//   id("org.jetbrains.dokka") version "1.7.0a-SNAPSHOT"
   id("org.jetbrains.dokka") version "1.7.0"
}

allprojects {
   repositories {
      google()
      mavenCentral()
      maven { url = uri("https://nexus.scanbot.io/nexus/content/repositories/snapshots/") }
   }
}

tasks.create("clean", type = Delete::class) {
   delete(rootProject.buildDir)
}

val dokkaCollectorTask = tasks.named("dokkaJavadocCollector", org.jetbrains.dokka.gradle.DokkaCollectorTask::class.java) {
   outputDirectory.set(File("build/docs/kdoc"))
}
