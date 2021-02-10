package com.mucyofred.uber.demo.repo

import com.mucyofred.uber.demo.models.User
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Query.query
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
class UserRepo (private val template: ReactiveMongoTemplate) {
    fun findAll() = template.findAll(User::class.java)
    fun findById(id: String) = template.findById(id, User::class.java)
    fun save(user: Mono<User>) = template.save(user)
    fun deleteById(id: String) = template.remove(Query().addCriteria(Criteria.where("id").`is`(id)), User::class.java)
    fun deleteAll() = template.remove(Query(), User::class.java)
    fun findByUsername(username: String) = template.findOne(query(where("username").`is`(username)), User::class.java)
    fun findByPhoneNumber(phone: String) = template.findOne(query(where("phoneNumber").`is`(phone)), User::class.java)
    fun findByIdNumber(idNumber: String) = template.findOne(query(where("idNumber").`is`(idNumber)), User::class.java)
}