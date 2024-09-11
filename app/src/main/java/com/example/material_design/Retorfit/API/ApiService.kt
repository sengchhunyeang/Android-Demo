package com.example.material_design.Retorfit.API



import com.example.material_design.Retorfit.Model.UserResponse
import retrofit2.http.GET
import retrofit2.Call

interface UserService {
    //    @GET("/api/v1/articles")
    @GET("/users")
    suspend fun getUser(): List<UserResponse>
}