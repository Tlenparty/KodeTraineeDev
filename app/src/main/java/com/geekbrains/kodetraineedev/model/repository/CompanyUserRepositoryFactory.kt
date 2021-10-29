package com.geekbrains.kodetraineedev.model.repository

import com.geekbrains.kodetraineedev.api.KodeTrainingApiFactory

object CompanyUserRepositoryFactory {
    fun create():CompanyUserRepository = CompanyUserRepositoryImp(KodeTrainingApiFactory.create())
}