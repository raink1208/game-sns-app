package com.github.raink1208.gamesnsapp.server.application.service

import com.github.raink1208.gamesnsapp.server.domain.model.User
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserUniqueId

interface IUserService {
    fun registerUser(userId: String, userName: String): User
    fun findUserById(userId: String): User?
    fun findUsersByName(userName: String): List<User>
    fun updateUserId(uniqueId: String, newUserId: String)
    fun updateUsername(uniqueId: UserUniqueId, newUserName: String): User
}