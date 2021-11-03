package com.geekbrains.kodetraineedev.model.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CompanyUser(

    @SerializedName("firstName")
    val firstName: String,

    @SerializedName("lastName")
    val lastName: String,

    @Expose
    @SerializedName("avatarUrl")
    val avatarUrl: String,

    @Expose()
    @SerializedName("department")
    val department: String,

    @Expose()
    @SerializedName("birthday")
    val birthday: String,

    @Expose()
    @SerializedName("userTag")
    val userTag: String,

    @Expose()
    @SerializedName("phone")
    val phone: String

)

/*
"items": [
{
    "id": "e0fceffa-cef3-45f7-97c6-6be2e3705927",
    "avatarUrl": "https://cdn.fakercloud.com/avatars/marrimo_128.jpg",
    "firstName": "Dee",
    "lastName": "Reichert",
    "userTag": "LK",
    "department": "back_office",
    "position": "Technician",
    "birthday": "2004-08-02",
    "phone": "802-623-1785"
},*/

//   https://stoplight.io/mocks/kode-education/trainee-test/25143926/users