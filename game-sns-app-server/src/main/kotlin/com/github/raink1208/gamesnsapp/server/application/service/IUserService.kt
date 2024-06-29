package com.github.raink1208.gamesnsapp.server.application.service

import com.github.raink1208.gamesnsapp.server.domain.model.User

interface IUserService {
    fun findUserByUniqueId(uniqueId: String): User?
    fun findUserById(userId: String): User?
    fun findUsersByName(userName: String): List<User>
}