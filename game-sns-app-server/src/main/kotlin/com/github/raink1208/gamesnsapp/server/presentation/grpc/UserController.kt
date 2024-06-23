package com.github.raink1208.gamesnsapp.server.presentation.grpc

import com.github.raink1208.gamesnsapp.common.protos.*
import com.github.raink1208.gamesnsapp.server.application.service.UserService
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class UserController(private val userService: UserService): UserServiceGrpcKt.UserServiceCoroutineImplBase() {
    override suspend fun register(request: CreateUserRequest): CreateUserRequest {
        return super.register(request)
    }

    override suspend fun findById(request: FindByIdRequest): FindUserResponse {
        val user = userService.findUserById(request.userId)
        return super.findById(request)
    }

    override suspend fun searchUserByName(request: SearchUserByNameRequest): SearchUserResponse {
        return super.searchUserByName(request)
    }
}