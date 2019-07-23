package com.jeziellago.hellokoin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jeziellago.hellokoin.presentation.state.HelloState
import com.jeziellago.hellokoin.presentation.usecase.HelloUseCase

class HelloViewModel(private val helloUseCase: HelloUseCase) : ViewModel() {

    private val _state = MutableLiveData<HelloState>()

    val state: LiveData<HelloState>
        get() = _state


    fun showHelloMessage() {
        val hello = helloUseCase.sayHello()
        _state.postValue(HelloState.ShowHello(hello))
    }


}