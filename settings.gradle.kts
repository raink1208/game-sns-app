plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "game-sns-app"

include("game-sns-app-server")
include("common")
