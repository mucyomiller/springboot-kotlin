package com.mucyofred.uber.demo.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @RequestMapping("/")
    fun hello() : String
    {
        return "Demo Application is running... :)";
    }
}