package com.example.material_design.Retorfit.API

import com.example.material_design.Retorfit.Model.ApiResponse
import com.example.material_design.Retorfit.Model.ArticleResponse
import com.example.material_design.Retrofit2.Model.ArticleRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

//ApiService.kt
interface ApiService {
    @GET("api/v1/articles")
    fun getArticles(): Call<ApiResponse>
    @POST("api/v1/articles")
    fun createArticle(@Body article: ArticleRequest):Call<Void>

    @DELETE("api/v1/articles/{id}")
    fun deleteArticle(@Path("id") id: Int): Call<Void>

    @PUT("api/v1/articles/{id}")
    fun updateArticle(
        @Path("id") id: Int,
        @Body article: ArticleRequest
    ): Call<Void>
    @GET("api/v1/articles/{id}")
    fun getArticleById(@Path("id") id: Int): Call<ArticleResponse>
}
