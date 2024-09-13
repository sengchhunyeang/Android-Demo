package com.example.material_design.Retrofit2.Route

sealed class Screen(val route: String) {
    data object InputArticle:Screen("input_article")
    data object  ListScreen:Screen("list_screen")
    data object  UpdateArticleScreen:Screen("update_article_screen")
}
