package com.geekbrains.kodetraineedev.model.repository

import com.geekbrains.kodetraineedev.api.KodeTrainingApi
import com.geekbrains.kodetraineedev.model.entities.ItemsDTO
import io.reactivex.Single

class CompanyUserRepositoryImp(private val kodeTrainingApi: KodeTrainingApi) :
    CompanyUserRepository {

    override fun getUsersFromServer(): Single<ItemsDTO> = kodeTrainingApi.getUsers()
}