package org.rikka.guitar

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform