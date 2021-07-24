plugins {
    id("org.jetbrains.kotlin.jvm").version("1.5.20").apply(false)
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

subprojects {
    group = "tf.veriny.ss76"

    apply(plugin = "kotlin")

    val implementation by configurations
    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation(kotlin("reflect"))
    }

    configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension> {
        explicitApi = org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode.Strict
    }

    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-Xopt-in=kotlin.RequiresOptIn",  // Enable @OptIn
                    "-Xstring-concat=indy-with-constants",  // Enable invokedynamic string concat
                    "-Xjvm-default=all",  // Forcibly enable Java 8+ default interface methods
                    "-Xassertions=always-enable"  // Forcibly enable assertions
                )
                jvmTarget = "16"
            }
        }
    }
}