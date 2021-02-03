package com.mucyofred.uber.demo.models

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime


@Document
data class Cab(
    @Id() var id: String? = null,
    var plateNumber: String? = null,
    var carModel: String? = null,
    var ownerId: String? = null,
    var activeStats: Boolean = false,
    @CreatedDate var createdDate: LocalDateTime = LocalDateTime.now()
)