package com.example.material_design.Retorfit.Model

import com.google.gson.annotations.SerializedName


data class UserResponse(
    @SerializedName("id")
    var id:String?=null,
    @SerializedName("name")
    var name:String?=null,
    @SerializedName("email")
    var email:String?=null,
    @SerializedName("avatar")
    var avatar:String?=null,
)
