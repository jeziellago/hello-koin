package com.jeziellago.hellokoin

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jeziellago.hellokoin.di.helloModule
import com.jeziellago.hellokoin.presentation.state.HelloState
import com.jeziellago.hellokoin.presentation.viewmodel.HelloViewModel
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject

class HelloViewModelTest : AutoCloseKoinTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setupTest() {
        startKoin {
            modules(helloModule)
        }
    }

    @Test
    fun `When call show hello method, assert that state is changed` () {
        val helloViewModel by inject<HelloViewModel>()

        helloViewModel.showHelloMessage()

        assertThat(helloViewModel.state.value, IsInstanceOf(HelloState.ShowHello::class.java))
    }
}