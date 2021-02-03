package com.mucyofred.uber.demo.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
data class User(
    @Id() var id: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var dob: String? = null,
    var username: String? = null,
    var idNumber: String? = null,
    var phoneNumber: String? = null,
    var password: String? = null, //TODO: Bcrypt password
)