package com.github.raink1208.gamesnsapp.server.infrastructure.repository.user

import com.github.raink1208.gamesnsapp.server.application.dto.UserDTO
import com.github.raink1208.gamesnsapp.server.domain.model.User
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserId
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserName

interface IUserRepository {
    fun register(user: User)
    fun save(user: User)
    fun findById(userId: UserId): UserDTO?
    fun findByUserName(userName: UserName): List<UserDTO>
}