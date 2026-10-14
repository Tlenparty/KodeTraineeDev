package com.tlenparty.kodetraineedev.model.repositories.company

import com.tlenparty.kodetraineedev.model.entities.CompanyUser
import com.tlenparty.kodetraineedev.model.entities.ItemsDTO
import io.reactivex.Single

interface CompanyUserRepository {
    fun getUsersFromServer(): Single<ItemsDTO>
}