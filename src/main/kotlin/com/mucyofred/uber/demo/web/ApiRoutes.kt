package com.mucyofred.uber.demo.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router

@Configuration
class ApiRoutes(
    val homeHandler: HomeHandler,
    val cabHandler: CabHandler,
    val driverHandler: DriverHandler,
    val userHandler: UserHandler,
) {

    @Bean
    fun appRouter() = router {
        accept(APPLICATION_JSON).nest {
            "/".nest {
                GET("/", homeHandler::home)
            }
            "/api/users".nest {
                GET("/", userHandler::findAll)
                GET("/{id}", cabHandler::findByPlateNumber)
            }
            "/api/cabs".nest {
                GET("/", cabHandler::findAll)
                POST("/", cabHandler::save)
                GET("/{plateNumber}", cabHandler::findByPlateNumber)
            }
            "/api/users".nest {
                GET("/", userHandler::findAll)
                POST("/", userHandler::save)
                GET("/{id}", userHandler::findById)
                GET("/{idNumber}", userHandler::findByIdNumber)
            }
            "/api/drivers".nest {
                GET("/", driverHandler::findAll)
                POST("/", driverHandler::save)
                GET("/{id}", driverHandler::findById)
                GET("/{idNumber}", driverHandler::findByDriverLicense)
            }
            "/api/payments".nest {
                GET("/", driverHandler::findAll)
                POST("/", driverHandler::save)
                GET("/{id}", driverHandler::findById)
                GET("/{driverLicense}", driverHandler::findByDriverLicense)
            }
            "/api/shifts".nest {
                GET("/", driverHandler::findAll)
                POST("/", driverHandler::save)
                GET("/{id}", driverHandler::findById)
                GET("/{idNumber}", driverHandler::findByDriverLicense)
            }
        }
    }
}