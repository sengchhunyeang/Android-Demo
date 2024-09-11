package com.example.material_design.Retorfit.API

import com.example.material_design.Retorfit.Model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/articles")
    fun getArticles(): Call<ApiResponse>
}
