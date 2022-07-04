plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.beryx.runtime").version("1.12.5")
}

repositories {
    mavenLocal()
}

dependencies {
    implementation("tf.veriny.pebbles:pebbles-engine:0.7.1")
}

application {
    mainClass.set("tf.veriny.ss76.MakeUp")
    applicationName = "signalling-system-76"
    applicationDefaultJvmArgs += "-Ddemo=true"
    applicationDefaultJvmArgs += "-Ddebug=true"
    applicationDefaultJvmArgs += "-Xmx400M"
}

runtime {
    jpackage {
        imageName = "signalling-system-76"
        targetPlatformName = "linux-x64"
        skipInstaller = true
    }

    /*val javaToolchains: JavaToolchainService =
        extensions.getByName("javaToolchains") as JavaToolchainService
    val toolchain = javaToolchains.compilerFor {
        languageVersion.set(JavaLanguageVersion.of(17))
    }*/

    targetPlatform("linux-x64") {
        setJdkHome(jdkDownload("https://cdn.azul.com/zulu/bin/zulu18.30.11-ca-jdk18.0.1-linux_x64.tar.gz"))
    }

    targetPlatform("macos-x64") {
        setJdkHome(jdkDownload("https://cdn.azul.com/zulu/bin/zulu18.30.11-ca-jdk18.0.1-macosx_x64.tar.gz"))
    }

    targetPlatform("macos-m1") {
        setJdkHome(jdkDownload("https://cdn.azul.com/zulu/bin/zulu18.30.11-ca-jdk18.0.1-macosx_aarch64.tar.gz"))
    }

    targetPlatform("windows") {
        setJdkHome(jdkDownload("https://cdn.azul.com/zulu/bin/zulu18.30.11-ca-jdk18.0.1-win_x64.zip"))
    }

    additive.set(true)
    addModules("jdk.unsupported", "jdk.zipfs", "java.logging")

    launcher {
        noConsole = true
    }
}