package extensions

import org.gradle.api.Project
import java.io.File

fun Project.prop(propertyName: String, defaultValue: Any): Any {
    return project.properties[propertyName] ?: (System.getenv(propertyName)
        ?: defaultValue)
}

fun Project.getFile(vararg fileNames: String): File? {
    for (fileName in fileNames) {
        val file = rootProject.file(fileName)
        if (file.exists()) {
            return file
        }
    }
    return null
}