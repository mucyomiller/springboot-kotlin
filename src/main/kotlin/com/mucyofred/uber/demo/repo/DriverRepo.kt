package com.mucyofred.uber.demo.repo

import com.mucyofred.uber.demo.models.Driver
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
class DriverRepo(private val template: ReactiveMongoTemplate) {
    fun findAll() = template.findAll(Driver::class.java)
    fun findById(id: String) = template.findById(id, Driver::class.java)
    fun save(driver: Mono<Driver>) = template.save(driver)
    fun deleteById(id: String) = template.remove(Query().addCriteria(Criteria.where("id").`is`(id)), Driver::class.java)
    fun deleteAll() = template.remove(Query(), Driver::class.java)
    fun findByDriverLicense(driverLicense: String) = template.findOne(
        Query.query(
            Criteria.where("drivingLicense").`is`(driverLicense)
        ), Driver::class.java
    )
}