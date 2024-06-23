package com.github.raink1208.gamesnsapp.server.infrastructure.repository

import com.github.raink1208.gamesnsapp.server.application.dto.UserDTO
import com.github.raink1208.gamesnsapp.server.domain.model.User
import com.github.raink1208.gamesnsapp.server.domain.repository.IUserRepository
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserId
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserName
import org.springframework.stereotype.Repository

@Repository
class UserRepository: IUserRepository {
    override fun register(user: User) {
        TODO("Not yet implemented")
    }

    override fun save(user: User) {
        TODO("Not yet implemented")
    }

    override fun findById(userId: UserId): UserDTO {
        TODO("Not yet implemented")
    }

    override fun findByUserName(userName: UserName): List<UserDTO> {
        TODO("Not yet implemented")
    }
}