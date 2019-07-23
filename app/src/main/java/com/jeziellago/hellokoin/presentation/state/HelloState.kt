package com.jeziellago.hellokoin.presentation.state

import com.jeziellago.hellokoin.domain.entities.Hello

sealed class HelloState {

    data class ShowHello(val hello: Hello): HelloState()
}