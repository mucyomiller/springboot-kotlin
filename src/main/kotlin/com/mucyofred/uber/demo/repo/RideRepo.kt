package com.mucyofred.uber.demo.repo

import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Repository

@Repository
class RideRepo (private val template: ReactiveMongoTemplate){

}