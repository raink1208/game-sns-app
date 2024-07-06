package com.github.raink1208.gamesnsapp.server.application.service

import com.github.raink1208.gamesnsapp.server.application.exception.UserIdAlreadyExistsException
import com.github.raink1208.gamesnsapp.server.application.exception.UserNotFoundException
import com.github.raink1208.gamesnsapp.server.domain.factory.UserFactory
import com.github.raink1208.gamesnsapp.server.domain.model.User
import com.github.raink1208.gamesnsapp.server.infrastructure.repository.user.IUserRepository
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserId
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserName
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserUniqueId
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserService (
    private val userRepository: IUserRepository,
    private val userFactory: UserFactory
): IUserService {
    private val logger = LoggerFactory.getLogger(UserService::class.java)

    override fun registerUser(userIdStr: String, userNameStr: String): User {
        logger.info("register request UserId: $userIdStr")

        val userId = UserId(userIdStr)
        val userName = UserName(userNameStr)

        if (userRepository.findById(userId) == null)
            throw UserIdAlreadyExistsException("Already Exists UserId: $userIdStr")

        val user = userFactory.registerUser(userId, userName)
        userRepository.register(user)

        return user
    }

    override fun findUserById(userIdStr: String): User? {
        logger.info("find user by UserId: $userIdStr")

        val userDto = userRepository.findById(UserId(userIdStr)) ?:
            throw UserNotFoundException("User not found by UserId: $userIdStr")

        return userFactory.createUser(userDto)
    }

    override fun searchUserByName(userNameStr: String): List<User> {
        logger.info("search user by UserName: $userNameStr")

        val userName = UserName(userNameStr)
        val users = userRepository.findByUserName(userName)

        return users.map { userFactory.createUser(it) }
    }

    override fun updateUserId(uniqueIdStr: String, newUserIdStr: String): User {
        logger.info("update userId uniqueId: $uniqueIdStr to newUserId: $newUserIdStr")

        if (userRepository.findById(UserId(newUserIdStr)) != null)
            throw UserIdAlreadyExistsException("Already Exists UserId: $newUserIdStr")

        val uniqueId = UserUniqueId.parseStr(uniqueIdStr)

        val userDto = userRepository.findByUniqueId(uniqueId) ?:
            throw UserNotFoundException("User not found by UniqueId: $uniqueId")
        val user = userFactory.createUser(userDto)

        user.changeUserId(newUserIdStr)
        userRepository.save(user)

        return user
    }

    override fun updateUserName(uniqueIdStr: String, newUserNameStr: String): User {
        logger.info("update userId uniqueId: $uniqueIdStr to newUserName: $newUserNameStr")

        val uniqueId = UserUniqueId.parseStr(uniqueIdStr)

        val userDto = userRepository.findByUniqueId(uniqueId) ?:
            throw UserNotFoundException("User not found by UniqueId: $uniqueId")
        val user = userFactory.createUser(userDto)

        user.changeUserName(newUserNameStr)
        userRepository.save(user)

        return user
    }
}