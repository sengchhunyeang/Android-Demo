package com.example.material_design.Retrofit2.Model

data class ArticleRequest (
    val title: String,
    val content: String,
    val imageUrl: String,
    val author: String,
    val publishedDate: String,
    val views: Int,
    val isPublished: Boolean
)