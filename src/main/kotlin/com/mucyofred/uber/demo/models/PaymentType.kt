package com.mucyofred.uber.demo.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class PaymentType(@Id() var id: String? = null, var typeName: String? = null)