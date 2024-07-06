package com.github.raink1208.gamesnsapp.server.infrastructure.repository.user

import com.github.raink1208.gamesnsapp.server.domain.model.User

interface IUserCacheRepository {
    fun put(user: User)
    fun get(user: User): User?
}