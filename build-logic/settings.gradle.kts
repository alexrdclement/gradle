rootProject.name = "build-logic"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    versionCatalogs {
        create("embarrasdfPluginLibs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}
