package com.mucyofred.uber.demo.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Driver(
    @Id() var id: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var dob: String? = null,
    var drivingLicense: String? = null,
    var expiryDate: LocalDateTime? = null,
    var isWorking: Boolean = false
)