package com.jeziellago.hellokoin.domain.repositories

interface HelloRepository {

    fun fetchHelloMessage(): String
}