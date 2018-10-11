package com.mitesh.kotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class Main{

    @Bean
    fun restTemplate() : RestTemplate{
        return RestTemplate()
    }
}

fun main(args:Array<String>){
    SpringApplication.run(Main::class.java, *args)
}