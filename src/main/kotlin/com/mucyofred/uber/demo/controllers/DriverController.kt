package com.mucyofred.uber.demo.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.awt.PageAttributes

@RestController
@RequestMapping("/drivers")
class DriverController {
    @RequestMapping("/{driverId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(value = HttpStatus.OK)
    fun getDriver(@PathVariable("driverId") driverId: String): String {
        return driverId;
    }
}