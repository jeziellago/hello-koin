package com.jeziellago.hellokoin.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.jeziellago.hellokoin.domain.entities.Hello
import com.jeziellago.hellokoin.R
import com.jeziellago.hellokoin.di.initHelloDependencies
import com.jeziellago.hellokoin.presentation.state.HelloState
import com.jeziellago.hellokoin.presentation.viewmodel.HelloViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val helloViewModel: HelloViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initHelloDependencies()
        setupViewModel()
    }

    private fun setupViewModel() {
        helloViewModel.state.observe(this, Observer {
            when(it) {
                is HelloState.ShowHello -> showHello(it.hello)
            }
        })

        helloViewModel.showHelloMessage()
    }

    private fun showHello(hello: Hello) {
        txtHello.text = hello.message
    }
}
