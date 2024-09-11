package com.example.material_design.Retorfit.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.material_design.Retorfit.API.RetrofitClient
import com.example.material_design.Retorfit.API.RetrofitInstant
import com.example.material_design.Retorfit.Model.ArticleResponse
import com.example.material_design.Retorfit.Model.ApiResponse
import kotlinx.coroutines.launch
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
}
