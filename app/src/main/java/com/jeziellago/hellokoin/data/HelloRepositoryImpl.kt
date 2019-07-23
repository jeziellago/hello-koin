package com.jeziellago.hellokoin.data

import com.jeziellago.hellokoin.domain.repositories.HelloRepository

internal class HelloRepositoryImpl : HelloRepository {

    override fun fetchHelloMessage(): String {
        return "Hello Koin!"
    }

}