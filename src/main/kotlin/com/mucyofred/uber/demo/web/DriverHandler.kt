package com.mucyofred.uber.demo.web

import com.mucyofred.uber.demo.models.Driver
import com.mucyofred.uber.demo.repo.DriverRepo
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body

@Component
class DriverHandler(private val driverRepository: DriverRepo) {

    fun findAll(req: ServerRequest) = ok().body(driverRepository.findAll())
    fun save(req: ServerRequest) = ok().body(driverRepository.save(req.bodyToMono(Driver::class.java)))
    fun findById(req: ServerRequest) = ok().body(driverRepository.findById(req.pathVariable("id")))
    fun findByDriverLicense(req: ServerRequest) = ok().body(driverRepository.findByDriverLicense(req.pathVariable("driverLicense")))

}