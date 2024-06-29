package com.github.raink1208.gamesnsapp.server.application.service

import com.github.raink1208.gamesnsapp.server.application.exception.UserIdAlreadyExistsException
import com.github.raink1208.gamesnsapp.server.application.exception.UserNotFoundException
import com.github.raink1208.gamesnsapp.server.domain.factory.UserFactory
import com.github.raink1208.gamesnsapp.server.domain.model.User
import com.github.raink1208.gamesnsapp.server.infrastructure.repository.user.IUserRepository
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserId
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserName
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserUniqueId
import de.huxhorn.sulky.ulid.ULID
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

        val id = UserId(userIdStr)
        val name = UserName(userNameStr)

        if (userRepository.findById(id) == null)
            throw UserIdAlreadyExistsException("Already Exists UserId: $userIdStr")

        val user = userFactory.registerUser(id, name)

        userRepository.register(user)

        return user
    }

    override fun findUserById(userIdStr: String): User? {
        logger.info("find user by UserId: $userIdStr")

        val userDto = userRepository.findById(UserId(userIdStr)) ?:
            throw UserNotFoundException("User not found by UserId: $userIdStr")
        val user = userFactory.createUser(userDto)
        return user
    }

    override fun searchUserByName(userNameStr: String): List<User> {
        logger.info("search user by UserName: $userNameStr")

        val name = UserName(userNameStr)
        val users = userRepository.findByUserName(name)

        return users.map { userFactory.createUser(it) }
    }

    override fun updateUserId(uniqueIdStr: String, newUserIdStr: String): User {
        logger.info("update userId uniqueId: $uniqueIdStr to newUserId: $newUserIdStr")
        if (userRepository.findById(UserId(uniqueIdStr)) != null)
            throw UserIdAlreadyExistsException("Already Exists UserId: $newUserIdStr")

        val id = UserUniqueId(ULID.parseULID(uniqueIdStr))
        val userId = UserId(newUserIdStr)

        val userDto = userRepository.findByUniqueId(id) ?:
            throw UserNotFoundException("User not found by UniqueId: $id")
        val user = userFactory.createUser(userDto)

        val newUser = userFactory.createUser(
            user.uniqueId,
            userId,
            user.userName,
            user.createdAt
        )

        userRepository.save(newUser)
        return newUser
    }

    override fun updateUsername(uniqueIdStr: UserUniqueId, newUserNameStr: String): User {
        logger.info("update userId uniqueId: $uniqueIdStr to newUserId: $newUserNameStr")
    }
}