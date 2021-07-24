plugins {
    id("application")
}

dependencies {
    implementation(project(":core"))
    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:1.10.0")
    implementation("com.badlogicgames.gdx:gdx-platform:1.10.0:natives-desktop")
    implementation("com.badlogicgames.gdx:gdx-freetype-platform:1.10.0:natives-desktop")
}

tasks.named<JavaExec>("run") {
    workingDir = rootProject.file("assets")
    isIgnoreExitValue = true
}

kotlin {
    explicitApi = org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode.Strict
}