package com.github.raink1208.gamesnsapp.server.application.dto

data class UserDTO(
    val uniqueId: String,
    val userId: String,
    val userName: String,
    val createdAt: Long
)