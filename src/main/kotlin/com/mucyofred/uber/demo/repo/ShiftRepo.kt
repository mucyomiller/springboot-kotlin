package com.mucyofred.uber.demo.repo

import com.mucyofred.uber.demo.models.Shift
import com.mucyofred.uber.demo.models.User
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
class ShiftRepo(private val template: ReactiveMongoTemplate) {
    fun findAll() = template.findAll(Shift::class.java)
    fun findById(id: String) = template.findById(id, User::class.java)
    fun save(user: User) = template.save(user)
    fun deleteById(id: String) = template.remove(Query().addCriteria(Criteria.where("id").`is`(id)), Shift::class.java)
    fun deleteAll() = template.remove(Query(), Shift::class.java)

    fun findByCabId(cabId: String) = template.findOne(
        Query.query(
            Criteria.where("cabId").`is`(cabId)
        ), User::class.java
    )

    fun findByIdNumber(idNumber: String) = template.findOne(
        Query.query(
            Criteria.where("idNumber").`is`(idNumber)
        ), User::class.java
    )

    fun findShiftsByDriverId(driverId: String) = template.find(
        Query.query(Criteria.where("driverUd").`is`(driverId)), Shift::class.java
    )
}