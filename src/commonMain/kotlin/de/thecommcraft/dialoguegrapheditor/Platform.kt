package de.thecommcraft.dialoguegrapheditor

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform