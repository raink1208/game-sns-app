package com.github.raink1208.gamesnsapp.server.domain.model

import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserId
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserName
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserUniqueId

data class User(
    val uniqueId: UserUniqueId,
    val userId: UserId,
    val userName: UserName,
    val createdAt: Long
) {
    override fun equals(other: Any?): Boolean {
        if (other !is User) return false
        return uniqueId == other.uniqueId
    }

    override fun hashCode(): Int {
        return uniqueId.hashCode()
    }
}