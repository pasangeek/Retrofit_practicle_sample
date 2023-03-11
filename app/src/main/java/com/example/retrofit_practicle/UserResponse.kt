package com.example.retrofit_practicle

class UserResponse (

    var page: Int,
    var perPage: Int,
    var total: Int,
    var totalPages,
    var data: List<user>,
    var support:Support
)

data class user (

    var id: Int,
    var email: String,
    var firstname: String,
    var lastName: String,
    var avatar: String


)
data class Support(

    var url :String,
    var text:String

)