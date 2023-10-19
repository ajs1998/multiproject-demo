plugins {
    java
}

subprojects {

    apply(plugin = "java")

    repositories {
        mavenCentral()
    }

    dependencies {
        testImplementation(rootProject.libs.junit)
        testRuntimeOnly(rootProject.libs.junitEngine)
    }

    tasks {
        /*
         * To update the JDK version:
         *
         * Change the jdk version in libs.versions.toml
         * Change the project's SDK version in IntelliJ (in Project Structure > Project)
         * Make sure IntelliJ's Gradle JVM is set to Project SDK
         */
        compileJava {
            sourceCompatibility = libs.versions.jdk.source.get()
            targetCompatibility = libs.versions.jdk.target.get()
        }

        test {
            useJUnitPlatform()
        }
    }

}

// All library projects have the java-library plugin
subprojects.filter {
    it.projectDir
        .relativeTo(rootDir)
        .startsWith("libraries")
}.forEach {
    it.apply(plugin = "java-library")
}

tasks {

    // Run `./gradlew graph -q` for the project dependency tree
    register("graph") {
        doLast {
            val map = mutableMapOf<String, MutableSet<String>>()
            subprojects.forEach { project ->
                project.configurations
                    .flatMap { it.dependencies}
                    .filterIsInstance<ProjectDependency>()
                    .forEach { dep ->
                        map.getOrPut (project.name) { mutableSetOf() }
                            .add(dep.dependencyProject.name)
                    }
            }
            logger.quiet(map.toString())
        }
    }

    /*
     * To update the Gradle wrapper version:
     *
     * Change the gradle-wrapper version in libs.versions.toml
     * Run `./gradlew wrapper`
     * Commit the changes
     */
    wrapper {
        gradleVersion = libs.versions.gradle.wrapper.get()
        distributionType = if (System.getenv("CI").toBoolean()) {
            Wrapper.DistributionType.BIN
        } else {
            // Useful if you ever want to read the source and javadocs instead of decompiled classes
            Wrapper.DistributionType.ALL
        }
    }

}
