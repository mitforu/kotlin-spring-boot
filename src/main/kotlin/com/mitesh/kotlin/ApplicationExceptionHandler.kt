package com.mitesh.kotlin

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest


@ControllerAdvice
class ApplicationExceptionHandler{

    val logger = LoggerFactory.getLogger(ApplicationExceptionHandler::class.java)

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(exception: RuntimeException, request : WebRequest){
        logger.error(exception.message, exception)
    }

}