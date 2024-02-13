package com.mbti.mongodbtestcontaierdemo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Customer(
    @Id
    val _id: String,
    val name: String,
    val age: Int
)
