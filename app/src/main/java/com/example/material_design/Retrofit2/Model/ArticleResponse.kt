package com.example.material_design.Retorfit.Model

import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("author") val author: String,
    @SerializedName("publishedDate") val publishedDate: String,
    @SerializedName("views") val views: Int,
    @SerializedName("isPublished") val isPublished: Boolean
)

data class ApiResponse(
    @SerializedName("message") val message: String,
    @SerializedName("payload") val payload: List<ArticleResponse>,
    @SerializedName("status") val status: String,
    @SerializedName("timestamp") val timestamp: String
)
