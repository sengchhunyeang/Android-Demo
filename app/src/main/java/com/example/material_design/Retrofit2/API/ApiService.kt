package com.example.material_design.Retorfit.API

import com.example.material_design.Retorfit.Model.ApiResponse
import com.example.material_design.Retrofit2.Model.ArticleRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

//ApiService.kt
interface ApiService {
    @GET("api/v1/articles")
    fun getArticles(): Call<ApiResponse>
    @POST("api/v1/articles")
    fun createArticle(@Body article: ArticleRequest):Call<Void>
}
