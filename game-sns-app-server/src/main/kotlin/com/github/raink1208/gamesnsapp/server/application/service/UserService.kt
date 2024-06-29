package com.github.raink1208.gamesnsapp.server.application.service

import com.github.raink1208.gamesnsapp.server.application.exception.UserNotFoundException
import com.github.raink1208.gamesnsapp.server.domain.factory.UserFactory
import com.github.raink1208.gamesnsapp.server.domain.model.User
import com.github.raink1208.gamesnsapp.server.infrastructure.repository.user.IUserRepository
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserId
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserService (
    private val userRepository: IUserRepository,
    private val userFactory: UserFactory
): IUserService {
    private val logger = LoggerFactory.getLogger(UserService::class.java)

    override fun findUserById(userId: String): User? {
        val userDto = userRepository.findById(UserId(userId)) ?:
            throw UserNotFoundException("User not found By UserId $userId")
        val user = userFactory.createUser(userDto)
        return user
    }

    override fun findUsersByName(userName: String): List<User> {
        TODO("Not yet implemented")
    }
}