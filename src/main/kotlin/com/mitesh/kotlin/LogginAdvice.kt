package com.mitesh.kotlin

import com.fasterxml.jackson.databind.ObjectMapper
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Before
import org.slf4j.LoggerFactory
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around


@Component
@Aspect
class LogginAdvice {

    val logger = LoggerFactory.getLogger(LogginAdvice::class.java)

    @Before("execution(* com.mitesh.kotlin.service.PersonService.retrievePerson(..))")
    fun logBefore(joinPoint: JoinPoint) {
        logger.info("logBefore() is running!")
        logger.info("Calling : ${joinPoint.signature.name} with Parameter :  ${ObjectMapper().writeValueAsString(joinPoint.args)}")
    }


    @After("execution(* com.mitesh.kotlin.service.PersonService.retrievePerson(..))")
    fun logAfter(joinPoint: JoinPoint) {
        logger.info("logAfter() is running!")
        logger.info("Method : ${joinPoint.signature.name}")
    }

    @AfterReturning("execution(* com.mitesh.kotlin.service.PersonService.retrievePerson(..))",
            returning= "result")
    fun logAfterReturning(joinPoint: JoinPoint, result: Any?) {
        logger.info("logAfterReturning() is running!")
        logger.info("Method : ${joinPoint.signature.name} Returned : ${ObjectMapper().writeValueAsString(result)}")
    }


    @Around("execution(* com.mitesh.kotlin.service.PersonService.savePerson(..))")
    @Throws(Throwable::class)
    fun logAround(joinPoint: ProceedingJoinPoint) : Any?{

        logger.info("logAround() is running!")
        logger.info("Calling : ${joinPoint.signature.name} with Parameter :  ${ObjectMapper().writeValueAsString(joinPoint.args)}")

        val result = joinPoint.proceed() //continue on the intercepted method

        logger.info("Method : ${joinPoint.signature.name} Returned :  ${ObjectMapper().writeValueAsString(result)}")

        return result
    }
}