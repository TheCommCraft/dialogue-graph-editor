package de.thecommcraft.dialoguegrapheditor


object JSPlatform : Platform {
    override val name: String = "JS"
}

actual fun getPlatform(): Platform = JSPlatform