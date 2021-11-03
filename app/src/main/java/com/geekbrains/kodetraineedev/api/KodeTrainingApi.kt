package com.geekbrains.kodetraineedev.api

import com.geekbrains.kodetraineedev.model.entities.ItemsDTO
import io.reactivex.Single
import retrofit2.http.GET

interface KodeTrainingApi {
    @GET("users")
    fun getUsers(): Single<ItemsDTO>

}
