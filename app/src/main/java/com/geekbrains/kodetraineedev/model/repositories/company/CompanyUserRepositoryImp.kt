package com.geekbrains.kodetraineedev.model.repositories.company

import android.annotation.SuppressLint
import com.geekbrains.kodetraineedev.api.KodeTrainingApi
import com.geekbrains.kodetraineedev.helpers.Constants
import com.geekbrains.kodetraineedev.model.entities.CompanyUser
import com.geekbrains.kodetraineedev.model.entities.ItemsDTO
import io.reactivex.Single

class CompanyUserRepositoryImp(private val kodeTrainingApi: KodeTrainingApi) :
    CompanyUserRepository {

    override fun getUsersFromServer(): Single<ItemsDTO> = kodeTrainingApi.getUsers()
}