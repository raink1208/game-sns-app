package com.github.raink1208.gamesnsapp.server.domain.model

import com.github.f4b6a3.tsid.Tsid
import com.github.raink1208.gamesnsapp.server.domain.valueobject.Game
import com.github.raink1208.gamesnsapp.server.domain.valueobject.PostContent

data class UserPost(
    val postId: Tsid,
    val user: User,
    val content: PostContent,
    val postedAt: Long,
    val game: Game?
) {
    override fun equals(other: Any?): Boolean {
        if (other !is UserPost) return false
        return postId == other.postId
    }

    override fun hashCode(): Int {
        return postId.hashCode()
    }
}