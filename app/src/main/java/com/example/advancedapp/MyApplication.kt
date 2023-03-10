package com.example.advancedapp

import android.app.Application
import com.example.advancedapp.di.DaggerRetroComponent
import com.example.advancedapp.di.RetroComponent
import com.example.advancedapp.di.RetroModule

class MyApplication: Application() {

    private lateinit var retroComponent: RetroComponent
    override fun onCreate() {
        super.onCreate()

        retroComponent = DaggerRetroComponent.builder()
            .retroModule(RetroModule())
            .build()
    }

    fun getRetroComponent(): RetroComponent {
        return retroComponent
    }
}