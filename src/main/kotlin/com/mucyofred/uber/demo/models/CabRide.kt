package com.mucyofred.uber.demo.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime


enum class RideStatus {
    PENDING, STARTED, CANCELED, ENDED
}

@Document
data class CabRide(
    @Id() var id: String? = null,
    var shiftId: String? = null,
    var rideStartTime: LocalDateTime? = null,
    var rideEndTime: LocalDateTime? = null,
    var rideStatus: RideStatus? = RideStatus.PENDING,
    var paymentType: PaymentType? = null,
)