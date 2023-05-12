package com.karamlyy.retrofittask.api

import com.karamlyy.retrofittask.model.Results
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("marvel")
    fun getsuperHeroes(): Call<List<Results>>
}