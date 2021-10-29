package com.geekbrains.kodetraineedev.model.repository

import com.geekbrains.kodetraineedev.model.entities.ItemsDTO
import io.reactivex.Single

interface CompanyUserRepository {
    fun getUsersFromServer(): Single<ItemsDTO>
}