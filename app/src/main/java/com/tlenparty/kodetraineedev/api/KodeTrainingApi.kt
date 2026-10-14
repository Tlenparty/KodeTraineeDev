package com.tlenparty.kodetraineedev.api

import com.tlenparty.kodetraineedev.model.entities.ItemsDTO
import io.reactivex.Single
import retrofit2.http.GET

interface KodeTrainingApi {
    @GET("users")
    fun getUsers(): Single<ItemsDTO>

}
