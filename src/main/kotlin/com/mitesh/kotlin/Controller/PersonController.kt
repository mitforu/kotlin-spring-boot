package com.mitesh.kotlin.Controller

import com.mitesh.kotlin.service.PersonService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(private val personService: PersonService){


    @GetMapping("/person/{personId}")
    fun retrievePerson(@PathVariable("personId") personId: Int) : Person{
        return personService.retrievePerson(personId)
    }
}

data class Person(
        val id: Int,
        val name : String
)