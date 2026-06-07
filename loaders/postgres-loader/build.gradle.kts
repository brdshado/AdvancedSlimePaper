plugins {
    id("asp.base-conventions")
    id("asp.publishing-conventions")
}

dependencies {
    compileOnly(project(":api"))

    api(libs.hikari)
    api("org.postgresql:postgresql:42.7.4")
    compileOnly(paperApi())
}

publishConfiguration {
    name = "Advanced Slime Paper PostgreSQL Loader"
    description = "PostgreSQL loader for Advanced Slime Paper"
}
