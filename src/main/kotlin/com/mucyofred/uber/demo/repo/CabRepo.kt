package com.mucyofred.uber.demo.repo

import com.mucyofred.uber.demo.models.Cab
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class CabRepo(private val template: ReactiveMongoTemplate) {
    fun findAll() = template.findAll(Cab::class.java)
    fun findById(id: String) = template.findById(id, Cab::class.java)
    fun save(cab: Cab) = template.save(cab)
    fun deleteById(id: String) = template.remove(Query().addCriteria(Criteria.where("id").`is`(id)), Cab::class.java)
    fun deleteAll() = template.remove(Query(), Cab::class.java)
}