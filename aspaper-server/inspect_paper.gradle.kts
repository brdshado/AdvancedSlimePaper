
abstract class ListMethods : DefaultTask() {
    @get:Internal
    abstract val target: org.gradle.api.provider.Property<Any>

    @TaskAction
    fun run() {
        val obj = target.get()
        println("Methods for ${obj.javaClass.name}:")
        obj.javaClass.methods.forEach { println(" - ${it.name}") }
    }
}

tasks.register<ListMethods>("listPaperMethods") {
    val pw = project.extensions.getByName("paperweight")
    // Use reflection to get the paper property because it might be a method or a property
    val paper = pw.javaClass.getMethod("getPaper").invoke(pw)
    target.set(paper)
}
