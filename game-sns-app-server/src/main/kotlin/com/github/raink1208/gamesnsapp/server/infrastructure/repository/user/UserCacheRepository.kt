package com.github.raink1208.gamesnsapp.server.infrastructure.repository.user

import com.github.raink1208.gamesnsapp.server.domain.model.User
import com.github.raink1208.gamesnsapp.server.domain.valueobject.UserUniqueId
import com.github.raink1208.gamesnsapp.server.util.LRUCacheHashMap
import org.springframework.stereotype.Repository

@Repository
class UserCacheRepository: IUserCacheRepository {
    private val cache: LRUCacheHashMap<UserUniqueId, User> = LRUCacheHashMap(256)

    override fun put(user: User) {
        cache[user.uniqueId] = user
    }

    override fun get(user: User): User? {
        return cache[user.uniqueId]
    }
}