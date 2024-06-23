package com.github.raink1208.gamesnsapp.server.application.service

import com.github.raink1208.gamesnsapp.server.domain.factory.UserFactory
import com.github.raink1208.gamesnsapp.server.domain.model.User
import com.github.raink1208.gamesnsapp.server.domain.repository.IUserRepository
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserId
import org.springframework.stereotype.Service

@Service
class UserService constructor (
    private val userRepository: IUserRepository,
    private val userFactory: UserFactory
) {
    fun findUserById(userId: String): User {
        val userDto = userRepository.findById(UserId(userId))
        val user = userFactory.createUser(userDto)
        return user
    }
}