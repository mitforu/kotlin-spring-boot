package com.mitesh.kotlin.service

import com.mitesh.kotlin.Controller.Person
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.RequestEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URI

@Service
class PersonService(
        private val restTemplate: RestTemplate
) {
    fun retrievePerson(personId: Int) : Person {
        restTemplate.getForObject(URI("http://localhost:8090/hello"), String::class.java)
        return Person(id = personId, name = "XYZ")
    }

    fun savePerson(person: Person) : Person {
        return person.copy(name = person.name + " Saved")
    }

    fun retrieveAllPersons() {
        throw RuntimeException("Person List Not Found.....")
    }

    fun getAllPerson(){

        val requestEntity = RequestEntity.method(HttpMethod.GET, URI("http://google.com")).build()

        val response = restTemplate.exchange(requestEntity, object: ParameterizedTypeReference<List<String>>(){})

        println(response.body)
    }
}