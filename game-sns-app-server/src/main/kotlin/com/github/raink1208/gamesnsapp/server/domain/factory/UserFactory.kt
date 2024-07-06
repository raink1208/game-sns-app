package com.github.raink1208.gamesnsapp.server.domain.factory

import com.github.raink1208.gamesnsapp.server.application.dto.UserDTO
import com.github.raink1208.gamesnsapp.server.domain.model.User
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserId
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserName
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserUniqueId
import org.springframework.stereotype.Component
import java.sql.Timestamp

@Component
class UserFactory {
    fun registerUser(userId: UserId, userName: UserName): User {
        val uniqueId = UserUniqueId.newId()
        val createdAt = Timestamp(System.currentTimeMillis()).time
        return User(uniqueId, userId, userName, createdAt)
    }

    fun createUser(userDto: UserDTO): User {
        val uniqueId = UserUniqueId.parseStr(userDto.uniqueId)
        val userId = UserId(userDto.userId)
        val userName = UserName(userDto.userName)

        return User(uniqueId, userId, userName, userDto.createdAt)
    }
}