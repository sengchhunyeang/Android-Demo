package com.example.material_design.Retorfit.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    //        private const val BASE_URL = "http://110.74.194.123:8080/api/v1/articles"
    private const val BASE_URL = "https://5e510330f2c0d300147c034c.mockapi.io/"
    val api: UserService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(UserService::class.java)
    }
}