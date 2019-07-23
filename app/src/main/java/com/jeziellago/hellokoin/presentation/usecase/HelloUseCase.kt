package com.jeziellago.hellokoin.presentation.usecase

import com.jeziellago.hellokoin.domain.entities.Hello
import com.jeziellago.hellokoin.domain.repositories.HelloRepository

class HelloUseCase(private val helloRepository: HelloRepository) {

    fun sayHello(): Hello {
        val message = helloRepository.fetchHelloMessage()
        return Hello(message)
    }
}