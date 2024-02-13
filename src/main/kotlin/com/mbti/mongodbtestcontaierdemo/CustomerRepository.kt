package com.mbti.mongodbtestcontaierdemo

import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository: MongoRepository<Customer, String> {
}
