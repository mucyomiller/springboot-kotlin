package com.mucyofred.uber.demo.repo

import com.mucyofred.uber.demo.models.PaymentType
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Repository
class PaymentRepo(private val template: ReactiveMongoTemplate) {
    fun findAll() = template.findAll(PaymentType::class.java)
    fun findById(id: String) = template.findById(id, PaymentType::class.java)
    fun save(payment: PaymentType) = template.save(payment)
    fun deleteById(id: String) =
        template.remove(Query().addCriteria(Criteria.where("id").`is`(id)), PaymentType::class.java)

    fun deleteAll() = template.remove(Query(), PaymentType::class.java)
}