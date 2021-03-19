plugins {
    kotlin("jvm") version "1.4.31"
}

group = "io.datalbry.testcontainers"
version = "1.0.0"

repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    val testcontainersVersion = "1.15.2"
    implementation(kotlin("stdlib"))
    implementation("org.testcontainers:testcontainers:$testcontainersVersion")

    testImplementation("org.testcontainers:junit-jupiter:$testcontainersVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}
