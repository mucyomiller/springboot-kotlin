package com.mucyofred.uber.demo.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Shift(
    @Id() var id: String? = null,
    var driverId: String? = null,
    var cabId: String? = null,
    var shiftStartTime: LocalDateTime? = null,
    var shiftEndTime: LocalDateTime? = null
)