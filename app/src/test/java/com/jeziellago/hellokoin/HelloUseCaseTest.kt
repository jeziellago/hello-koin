package com.jeziellago.hellokoin

import com.jeziellago.hellokoin.di.helloModule
import com.jeziellago.hellokoin.domain.repositories.HelloRepository
import com.jeziellago.hellokoin.presentation.usecase.HelloUseCase
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest
import org.koin.test.KoinTest
import org.koin.test.inject

class HelloUseCaseTest : AutoCloseKoinTest() {

    private val helloRepository by inject<HelloRepository>()

    @Before
    fun setupTest() {
        startKoin {
            modules(helloModule)
        }
    }

    @Test
    fun `Assert that say hello message return Hello object`() {
        val helloUseCase = HelloUseCase(helloRepository)

        val message = "Hello Koin!"

        val hello = helloUseCase.sayHello()

        assertThat(message, IsEqual(hello.message))

    }
}