package com.example.retrofit_practicle

import com.google.gson.annotations.SerializedName

data class UserResponse (

    var page: Int,
    @SerializedName("per_page")
    var perPage: Int,
    var total: Int,
    @SerializedName("total_pages")
    var totalPages:Int,
    var data: List<User>,
    var support:Support
)

data class User (

    var id: Int,
    var email: String,
    var first_Name: String,
    var last_Name: String,
    var avatar: String


)
data class Support(

    var url :String,
    var text:String

)