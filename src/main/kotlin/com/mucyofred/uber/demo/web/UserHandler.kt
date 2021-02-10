package com.mucyofred.uber.demo.web

import com.mucyofred.uber.demo.models.User
import com.mucyofred.uber.demo.repo.UserRepo
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body


@Component
class UserHandler(private val userRepository: UserRepo) {

    fun findAll(req: ServerRequest) = ServerResponse.ok().body(userRepository.findAll())
    fun findById(req: ServerRequest) = ServerResponse.ok().body(userRepository.findById(req.pathVariable("id")))
    fun findByIdNumber(req: ServerRequest) =
        ServerResponse.ok().body(userRepository.findByIdNumber(req.pathVariable("idNumber")))

    fun save(req: ServerRequest) = ServerResponse.ok().body(userRepository.save(req.bodyToMono(User::class.java)))
}