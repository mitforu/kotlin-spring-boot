package com.mitesh.kotlin.Controller

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.mitesh.kotlin.service.PersonService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
class PersonController(private val personService: PersonService){

    @GetMapping("/person/{personId}")
    fun retrievePerson(@PathVariable("personId") personId: Int) : Person{
        return personService.retrievePerson(personId)
    }

    @PostMapping("/person")
    @ResponseBody
    fun savePerson(@RequestBody person: Person) : Person{
        return personService.savePerson(person)
    }

    @GetMapping("/persons")
    fun retrieveAllPersons(){
        return personService.retrieveAllPersons()
    }
}


data class Person(
        @JsonProperty("id")
        var id: Int,
        @JsonProperty("name")
        var name : String
)