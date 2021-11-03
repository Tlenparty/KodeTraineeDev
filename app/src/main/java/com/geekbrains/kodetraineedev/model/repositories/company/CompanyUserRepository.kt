package com.geekbrains.kodetraineedev.model.repositories.company

import com.geekbrains.kodetraineedev.model.entities.ItemsDTO
import io.reactivex.Single

interface CompanyUserRepository {
    fun getUsersFromServer(): Single<ItemsDTO>
}