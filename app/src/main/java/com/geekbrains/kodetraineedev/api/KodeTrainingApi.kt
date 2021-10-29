package com.geekbrains.kodetraineedev.api

import com.geekbrains.kodetraineedev.model.entities.ItemsDTO
import io.reactivex.Single
import retrofit2.http.GET

interface KodeTrainingApi {
    // fun getUsers(): Single<List<CompanyUser>>
    @GET("users")
    fun getUsers(): Single<ItemsDTO>

}
