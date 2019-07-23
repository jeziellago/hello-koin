package com.jeziellago.hellokoin.di

import com.jeziellago.hellokoin.data.HelloRepositoryImpl
import com.jeziellago.hellokoin.domain.repositories.HelloRepository
import com.jeziellago.hellokoin.presentation.usecase.HelloUseCase
import com.jeziellago.hellokoin.presentation.viewmodel.HelloViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

internal val helloModule = module {
    viewModel { HelloViewModel(get()) }
    factory { HelloUseCase(get()) }
    factory<HelloRepository> { HelloRepositoryImpl() }
}

internal val helloDependencies by lazy { loadKoinModules(helloModule) }

internal fun initHelloDependencies() = helloDependencies