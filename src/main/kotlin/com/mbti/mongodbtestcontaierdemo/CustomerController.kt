package com.mbti.mongodbtestcontaierdemo

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(val customerRepository: CustomerRepository) {

    @PostMapping("/customers")
    fun save(): Customer =
        customerRepository.save(Customer("1234", "Jon Doe", 18))
}
