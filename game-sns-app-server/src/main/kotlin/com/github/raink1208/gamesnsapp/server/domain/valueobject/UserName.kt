package com.github.raink1208.gamesnsapp.server.domain.valueobject

data class UserName(
    val userName: String
) {
    init {
        if (userName.isBlank()) throw IllegalArgumentException("UserName cannot be empty")

    }

    override fun equals(other: Any?): Boolean {
        if (other !is UserName) return false
        return userName == other.userName
    }

    override fun hashCode(): Int {
        return userName.hashCode()
    }

    override fun toString(): String {
        return userName
    }
}
