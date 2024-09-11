
package com.example.material_design.Retorfit.API
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstant {
    private const val BASE_URL = "http://110.74.194.123:8080/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())//handle JSON serialization
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}
