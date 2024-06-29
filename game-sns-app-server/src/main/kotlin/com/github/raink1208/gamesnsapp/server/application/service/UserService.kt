package com.github.raink1208.gamesnsapp.server.application.service

import com.github.raink1208.gamesnsapp.server.application.exception.UserNotFoundException
import com.github.raink1208.gamesnsapp.server.domain.factory.UserFactory
import com.github.raink1208.gamesnsapp.server.domain.model.User
import com.github.raink1208.gamesnsapp.server.infrastructure.repository.user.IUserRepository
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserId
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserUniqueId
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserService (
    private val userRepository: IUserRepository,
    private val userFactory: UserFactory
): IUserService {
    private val logger = LoggerFactory.getLogger(UserService::class.java)

    override fun registerUser(userId: String, userName: String): User {
        TODO("Not yet implemented")
    }

    override fun findUserById(userId: String): User? {
        logger.info("find user by UserId: $userId")

        val userDto = userRepository.findById(UserId(userId)) ?:
            throw UserNotFoundException("User not found by UserId: $userId")
        val user = userFactory.createUser(userDto)
        return user
    }

    override fun searchUserByName(userName: String): List<User> {
        TODO("Not yet implemented")
    }

    override fun updateUserId(uniqueId: String, newUserId: String) {
        TODO("Not yet implemented")
    }

    override fun updateUsername(uniqueId: UserUniqueId, newUserName: String): User {
        TODO("Not yet implemented")
    }
}