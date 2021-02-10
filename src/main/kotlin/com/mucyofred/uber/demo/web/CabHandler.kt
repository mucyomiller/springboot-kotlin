package com.mucyofred.uber.demo.web

import com.mucyofred.uber.demo.models.Cab
import com.mucyofred.uber.demo.repo.CabRepo
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body

@Component
class CabHandler(private val cabRepository: CabRepo) {

    fun findByPlateNumber(req: ServerRequest) =
        ok().body(cabRepository.findByPlateNumber(req.pathVariable("plateNumber")))

    fun findAll(req: ServerRequest) = ok().body(cabRepository.findAll())
    fun save(req: ServerRequest) = ok().body(cabRepository.save(req.bodyToMono(Cab::class.java)))
}