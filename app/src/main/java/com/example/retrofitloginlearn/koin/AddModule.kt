package com.example.retrofitloginlearn.koin

import com.example.retrofitloginlearn.repository.Repository
import com.example.retrofitloginlearn.view.list.ListViewModel
import com.example.retrofitloginlearn.view.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { Repository() }
    viewModel { LoginViewModel(get()) }
    viewModel { ListViewModel(get()) }
}


