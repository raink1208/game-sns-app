plugins {
    kotlin("jvm") version "1.9.24" apply false
    id("com.google.protobuf") version "0.9.4" apply false
}

ext["grpcVersion"] = "1.64.0"
ext["grpcKotlinVersion"] = "1.4.1"
ext["protobufVersion"] = "4.27.1"
ext["coroutinesVersion"] = ""

allprojects {
    repositories {
        mavenLocal()
        maven("https://repo1.maven.org/maven2/")
        mavenCentral()
        google()
    }
}