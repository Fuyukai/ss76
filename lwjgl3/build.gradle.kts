plugins {
    id("application")
    id("kotlin")
}

dependencies {
    implementation(project(":core"))
    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:1.10.0")
    implementation("com.badlogicgames.gdx:gdx-platform:1.10.0:natives-desktop")
    implementation("com.badlogicgames.gdx:gdx-freetype-platform:1.10.0:natives-desktop")
}

base {
    archivesName.set("ss76-lwjgl3-launcher")
}

application {
    mainClass.set("tf.veriny.ss76.Lwjgl3Launcher")
    applicationName = "signalling-system-76"
    applicationDefaultJvmArgs += "-Ddemo=true"
}

tasks.named<JavaExec>("run") {
    isIgnoreExitValue = true
}

kotlin {
    explicitApi = org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode.Strict
}