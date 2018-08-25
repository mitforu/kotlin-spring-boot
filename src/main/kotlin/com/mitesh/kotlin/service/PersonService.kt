package com.mitesh.kotlin.service

import com.mitesh.kotlin.Controller.Person
import org.springframework.stereotype.Service

@Service
class PersonService {
    fun retrievePerson(personId: Int) : Person {
        return Person(id = personId, name = "XYZ");
    }
}