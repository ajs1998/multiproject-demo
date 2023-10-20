# Gradle multi-project build

- Intended for a monorepo with multiple java projects
- All subprojects are in `libraries/` and `services/` and the name of each project is the name of the directory
- External dependencies are declared in `gradle/libs.versions.toml`
- Dependencies between subprojects are declared using `project(":project-dependency")`
- `gradle.properties` enables build caching and parallelism, which are both disabled by default
- Build artifacts are cached in `build-cache/` and can be saved and restored by CI jobs
