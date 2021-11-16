plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.beryx.runtime").version("1.12.5")
}

base {
    archivesName.set("ss76")
}

dependencies {
    api("com.badlogicgames.gdx:gdx:1.10.0")
    api("com.badlogicgames.gdx:gdx-freetype:1.10.0")
    api("io.github.libktx:ktx-log:1.10.0-b2")
    api("io.github.libktx:ktx-freetype:1.10.0-b2")
    api("io.github.libktx:ktx-app:1.10.0-b2")
    api("io.github.libktx:ktx-assets:1.10.0-b2")
    api("io.github.libktx:ktx-graphics:1.10.0-b2")

    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:1.10.0")
    implementation("com.badlogicgames.gdx:gdx-platform:1.10.0:natives-desktop")
    implementation("com.badlogicgames.gdx:gdx-freetype-platform:1.10.0:natives-desktop")

    api("dev.dirs:directories:26")
    api("com.squareup.okio:okio:2.10.0")

}

