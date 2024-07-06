package com.github.raink1208.gamesnsapp.server.domain.valueobject

data class UserName(
    val userName: String
) {
    init {
        if (userName.isBlank()) throw IllegalArgumentException("UserName cannot be empty")

    }

    override fun toString(): String {
        return userName
    }
}
