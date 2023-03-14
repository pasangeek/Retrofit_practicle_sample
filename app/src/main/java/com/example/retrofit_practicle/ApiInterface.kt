package com.example.retrofit_practicle

import retrofit2.Response
import retrofit2.http.*


interface ApiInterface {

    @GET("/api/users?page=2")//https://reqres.in/api/users?page=2
    suspend fun getUsers(): Response<UserResponse>

   @GET("/api/users")//https://reqres.in/api/users?page=2
   suspend fun getUsers(@Query("page") pageNo: Int): Response<UserResponse>

   // @GET("/api/users/{userId}")//https://reqres.in/api/users/4562
   // fun getUserById(@Path("userId") userId: Int)

   // @POST("/api/users/new")
    //fun newUser(@Body user: User): Response<Int>


}