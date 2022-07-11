
plugins {
   id("com.android.library")
   id("kotlin-android")
   id("org.jetbrains.dokka")
}

android {
   defaultConfig {
      compileSdk = 30
      minSdk = 21
      targetSdk = 30
   }

   buildTypes {
      named("release") {
         isMinifyEnabled = false
         proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      }
   }

   compileOptions {
      sourceCompatibility = JavaVersion.VERSION_1_8
      targetCompatibility = JavaVersion.VERSION_1_8
   }
}

dependencies {
   implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.21")
   implementation("androidx.core:core-ktx:1.8.0")
   implementation("androidx.appcompat:appcompat:1.4.2")
}

tasks.named("dokkaJavadoc", org.jetbrains.dokka.gradle.DokkaTask::class.java) {
   outputDirectory.set(File(buildDir, "dokka_output"))

   suppressObviousFunctions.set(true)
   suppressInheritedMembers.set(true)

   dokkaSourceSets.configureEach {

      sourceRoots.setFrom(file("src/main/java"), file("src/main/kotlin"))

      includeNonPublic.set(false)
      skipDeprecated.set(false)
      reportUndocumented.set(false)
      skipEmptyPackages.set(true)
      jdkVersion.set(8)
      noStdlibLink.set(false)
      noJdkLink.set(false)
      noAndroidSdkLink.set(false)
      suppressGeneratedFiles.set(true)

      listOf(
         // looks like a bug, maybe refine this part later, when fixed
         // https://github.com/Kotlin/dokka/issues/1994
         """android\..*""",
         """androidx\..*""",
      ).forEach { packageRegex ->
         perPackageOption {
            matchingRegex.set(packageRegex)
            skipDeprecated.set(true)
         }
      }

//      suppressedFiles.setFrom(
//         listOf(
//            java.io.File("/Stub"),
//            java.io.File("/SapSingleton.kt"),
//            java.io.File("/SapProvider"),
//            java.io.File("/Disposable"),
//            java.io.File("/P2Module"),
//            java.io.File("/P3Module"),
//            java.io.File("/P4Module"),
//            java.io.File("/RtuConstants"),
//         )
//      )
   }
}