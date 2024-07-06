package com.github.raink1208.gamesnsapp.server.domain.model

import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserId
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserName
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserUniqueId

class User(
    val uniqueId: UserUniqueId,
    userId: UserId,
    userName: UserName,
    val createdAt: Long
) {
    var userId: UserId = userId; private set
    var userName: UserName = userName; private set

    fun changeUserId(userIdStr: String) {
        userId = UserId(userIdStr)
    }

    fun changeUserName(userNameStr: String) {
        userName = UserName(userNameStr)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is User) return false
        return uniqueId == other.uniqueId
    }

    override fun hashCode(): Int {
        return uniqueId.hashCode()
    }
}