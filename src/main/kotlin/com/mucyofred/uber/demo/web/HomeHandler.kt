package com.mucyofred.uber.demo.web

import com.mucyofred.uber.demo.models.Driver
import com.mucyofred.uber.demo.repo.UserRepo
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono


@Component
class HomeHandler(private val userRepository: UserRepo) {
    fun home(req: ServerRequest) = ServerResponse.ok().body(Mono.just("hello"))
}