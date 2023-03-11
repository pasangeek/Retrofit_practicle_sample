package com.example.retrofit_practicle

import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("/api/users?page=2")

    fun getUsers(): Response<UserResponse>



}