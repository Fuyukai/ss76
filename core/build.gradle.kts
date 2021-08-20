base {
    archivesName.set("ss76-core-game")
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

    implementation("org.apache.commons:commons-text:1.9")
}
