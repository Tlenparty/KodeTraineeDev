package com.tlenparty.kodetraineedev.model.repositories.company

import android.annotation.SuppressLint
import com.tlenparty.kodetraineedev.api.KodeTrainingApi
import com.tlenparty.kodetraineedev.helpers.Constants
import com.tlenparty.kodetraineedev.model.entities.CompanyUser
import com.tlenparty.kodetraineedev.model.entities.ItemsDTO
import io.reactivex.Single

class CompanyUserRepositoryImp(private val kodeTrainingApi: KodeTrainingApi) :
    CompanyUserRepository {

    override fun getUsersFromServer(): Single<ItemsDTO> = kodeTrainingApi.getUsers()
}