package com.github.raink1208.gamesnsapp.server.domain.valueobject

class UserId(
    val userId: String
) {
    companion object {
        private const val USERID_REGEX = "^[a-zA-Z0-9_.-]+$"
    }

    init {
        if (userId.isBlank()) throw IllegalArgumentException("UserId can't be empty")
        if (userId.length <= 3) throw IllegalArgumentException("UserId can't be longer than 3 characters")
        if (!USERID_REGEX.toRegex().matches(userId))
            throw IllegalArgumentException("UserId can't be valid")
    }

    override fun equals(other: Any?): Boolean {
        if (other !is UserId) return false
        return userId == other.userId
    }

    override fun hashCode(): Int {
        return userId.hashCode()
    }

    override fun toString(): String {
        return userId
    }
}