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

    implementation("dev.dirs:directories:26")
    implementation("com.squareup.okio:okio:2.10.0")

}

application {
    mainClass.set("tf.veriny.ss76.MakeUp")
    applicationName = "signalling-system-76"
    applicationDefaultJvmArgs += "-Ddemo=true"
    applicationDefaultJvmArgs += "-Ddebug=true"
}

runtime {
    jpackage {
        imageName = "signalling-system-76"
        targetPlatformName = "linux-x64"
        skipInstaller = true
    }

    val javaToolchains: JavaToolchainService =
        extensions.getByName("javaToolchains") as JavaToolchainService
    val toolchain = javaToolchains.compilerFor {
        languageVersion.set(JavaLanguageVersion.of(16))
    }

    targetPlatform("linux-x64") {
        setJdkHome(jdkDownload("https://cdn.azul.com/zulu/bin/zulu16.32.15-ca-jdk16.0.2-linux_x64.tar.gz"))
    }

    targetPlatform("macos-x64") {
        setJdkHome(jdkDownload("https://cdn.azul.com/zulu/bin/zulu16.32.15-ca-jdk16.0.2-macosx_x64.tar.gz"))
    }

    targetPlatform("macos-m1") {
        setJdkHome(jdkDownload("https://cdn.azul.com/zulu/bin/zulu16.32.15-ca-jdk16.0.2-macosx_aarch64.tar.gz"))
    }

    targetPlatform("windows") {
        setJdkHome(jdkDownload("https://cdn.azul.com/zulu/bin/zulu16.32.15-ca-jdk16.0.2-win_x64.zip"))
    }

    additive.set(true)
    addModules("jdk.unsupported", "jdk.zipfs")

    launcher {
        noConsole = true
    }
}

