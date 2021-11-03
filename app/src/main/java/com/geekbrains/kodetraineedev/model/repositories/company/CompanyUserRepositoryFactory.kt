package com.geekbrains.kodetraineedev.model.repositories.company

import com.geekbrains.kodetraineedev.api.KodeTrainingApiFactory

object CompanyUserRepositoryFactory {
    fun create(): CompanyUserRepository = CompanyUserRepositoryImp(KodeTrainingApiFactory.create())
}