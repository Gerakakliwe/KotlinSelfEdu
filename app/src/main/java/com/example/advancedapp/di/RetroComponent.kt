package com.example.advancedapp.di

import com.example.advancedapp.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RetroModule::class
    ]
)
interface RetroComponent {
    fun inject(mainActivityViewModel: MainActivityViewModel)
}