package com.github.raink1208.gamesnsapp.server.domain.valueobject

import com.github.f4b6a3.tsid.Tsid

data class Game(
    val gameId: Tsid,
    val name: String,
)