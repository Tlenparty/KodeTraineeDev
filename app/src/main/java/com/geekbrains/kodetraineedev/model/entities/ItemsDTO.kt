package com.geekbrains.kodetraineedev.model.entities

import com.google.gson.annotations.SerializedName

data class ItemsDTO(
    @SerializedName("items")
    val companyUser: List<CompanyUser>
)