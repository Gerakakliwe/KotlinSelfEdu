package com.example.advancedapp.di

import com.example.advancedapp.model.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInterface {

    @GET("repositories")
    fun getDataFromApi(@Query("q")query: String):Call<RecyclerList>?
}