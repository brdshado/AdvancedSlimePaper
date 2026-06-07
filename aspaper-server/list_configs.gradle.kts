
tasks.register("listConfigs") {
    doLast {
        configurations.forEach { println("Config: ${it.name}") }
    }
}
