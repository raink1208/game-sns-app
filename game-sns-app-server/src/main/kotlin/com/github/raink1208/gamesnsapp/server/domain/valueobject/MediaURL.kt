package com.github.raink1208.gamesnsapp.server.domain.valueobject

data class MediaURL(
    val url: String
) {
    companion object {
        private const val URL_REGEX = "^(https?://).+"
    }

    init {
        if (!URL_REGEX.toRegex().matches(url))
            throw IllegalArgumentException("Invalid URL: $url")
    }
}