package com.github.raink1208.gamesnsapp.server.domain.valueobject

import de.huxhorn.sulky.ulid.ULID

data class UserUniqueId(
    val uniqueId: ULID.Value
) {
    companion object {
        fun newId(): UserUniqueId {
            return UserUniqueId(ULID().nextValue())
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other !is UserUniqueId) return false

        return this.uniqueId == other.uniqueId
    }

    override fun hashCode(): Int {
        return uniqueId.hashCode()
    }
}
