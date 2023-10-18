import java.io.FileFilter

rootProject.name = "multiproject-demo"

val dirFileFilter = FileFilter { it.isDirectory }
listOf("libraries", "services")
    .map(::file)
    .flatMap { it.listFiles(dirFileFilter)?.toList() ?: emptyList() }
    .map { dir ->
        include(dir.name)
        project(":${dir.name}").projectDir = dir
    }
