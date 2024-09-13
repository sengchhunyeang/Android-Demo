package com.example.material_design.Retorfit.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.material_design.Retorfit.API.RetrofitInstant
import com.example.material_design.Retorfit.Model.ApiResponse
import com.example.material_design.Retorfit.Model.ArticleResponse
import com.example.material_design.Retrofit2.Model.ArticleRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel : ViewModel() {

    private val _articles = MutableLiveData<List<ArticleResponse>>()
    val articles: LiveData<List<ArticleResponse>> = _articles

    init {
        fetchArticles()
    }
    private fun fetchArticles() {
        RetrofitInstant.apiService.getArticles().enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    _articles.value = response.body()?.payload ?: emptyList()
//                    Log.d("viewData", "Data${response}")
                } else {
                    Log.e("ViewModel", "Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("ViewModel", "Failure: ${t.message}")
                _articles.value = emptyList()
            }
        })
    }

    fun createArticle(article: ArticleRequest, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        val apiService = RetrofitInstant.apiService
        apiService.createArticle(article).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    onSuccess()
                    fetchArticles()
                } else {
                    onFailure("Failed to create article")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                onFailure(t.message ?: "An error occurred")
            }

        })
    }

    fun deleteArticle(id: Int, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        RetrofitInstant.apiService.deleteArticle(id).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    onSuccess()
                    fetchArticles()
//                    Log.d("Delete", " ${response}")

                } else {
                    Log.e("DeleteArticle", "Failed: ${response.message()}")
                    onFailure("Failed to delete article: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                onFailure(t.message ?: "An error occurred")
            }
        })
    }

    fun getArticleById(id: Int): ArticleResponse {
        return _articles.value?.find { it.id == id }
            ?: throw IllegalArgumentException("Article not found")
    }
    fun updateArticle(id: Int, article: ArticleRequest, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        RetrofitInstant.apiService.updateArticle(id, article).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    fetchArticles()
                    onSuccess()
                } else {
                    onFailure("Failed to update article")
                }
            }
            override fun onFailure(call: Call<Void>, t: Throwable) {
                onFailure(t.message ?: "An error occurred")
            }
        })
    }
}
