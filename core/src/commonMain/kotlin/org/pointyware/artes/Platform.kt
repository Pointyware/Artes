package org.pointyware.artes

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform