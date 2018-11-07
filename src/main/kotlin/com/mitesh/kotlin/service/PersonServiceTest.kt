package com.mitesh.kotlin.service

import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate


class PersonServiceTest {

    @Test
    fun `getAllPerson`() {


        val restTemplate = Mockito.mock(RestTemplate::class.java)

        `when`(
                restTemplate.exchange(Matchers.any(),
                        Matchers.any<ParameterizedTypeReference<List<String>>>())
        ).thenReturn(ResponseEntity.ok(listOf("Hello","Hello1")))

        val subject = PersonService(
                restTemplate = restTemplate
        )

        subject.getAllPerson()


    }


}