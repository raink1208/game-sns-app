package com.github.raink1208.gamesnsapp.server.domain.valueobject

import de.huxhorn.sulky.ulid.ULID

@JvmInline
value class UserUniqueId private constructor(
    val uniqueId: ULID.Value
) {
    companion object {
        fun newId(): UserUniqueId {
            return UserUniqueId(ULID().nextValue())
        }

        fun parseStr(str: String): UserUniqueId {
            return UserUniqueId(ULID.parseULID(str))
        }
    }
}
