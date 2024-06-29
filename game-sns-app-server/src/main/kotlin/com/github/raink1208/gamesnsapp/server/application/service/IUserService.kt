package com.github.raink1208.gamesnsapp.server.application.service

import com.github.raink1208.gamesnsapp.server.domain.model.User
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserUniqueId

interface IUserService {
    fun registerUser(userIdStr: String, userNameStr: String): User
    fun findUserById(userIdStr: String): User?
    fun searchUserByName(userNameStr: String): List<User>
    fun updateUserId(uniqueIdStr: String, newUserIdStr: String): User
    fun updateUsername(uniqueIdStr: UserUniqueId, newUserNameStr: String): User
}