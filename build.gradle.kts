val osName = System.getProperty("os.name").toLowerCase()
var tcnative_classifier: String
tcnative_classifier = if (osName.contains("win")) {
    "windows-x86_64"
} else if (osName.contains("linux")) {
    "linux-x86_64"
} else if (osName.contains("mac")) {
    "osx-x86_64"
} else {
    ""
}

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val tcnative_version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.31"
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("com.example.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {

    // Generate a certificate in code - https://ktor.io/docs/ssl.html#self-signed-code
    implementation("io.ktor:ktor-network-tls-certificates:$ktor_version")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")

    // server
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")

    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.3")
    implementation("io.ktor:ktor-html-builder:$ktor_version")

    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation("io.netty:netty-tcnative:$tcnative_version")
    implementation("io.netty:netty-tcnative-boringssl-static:$tcnative_version")
    implementation("io.netty:netty-tcnative-boringssl-static:$tcnative_version:$tcnative_classifier")

    // test
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
}