package com.mbti.mongodbtestcontaierdemo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class IntegrationTest(
    @Autowired val webTestClient: WebTestClient
) {

    companion object {
        @Container
        @ServiceConnection
        val mongoDB = MongoDBContainer("mongo:latest")
    }

    @Test
    fun saveCustomerTest() {
        webTestClient
            .post()
            .uri("/customers")
            .exchange()
            .expectStatus().isOk
            .expectBody<Customer>().value { customer -> assertThat(customer._id).isEqualTo("1234") }
    }
}
