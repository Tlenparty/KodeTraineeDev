package com.tlenparty.kodetraineedev.model.repositories.company

import com.tlenparty.kodetraineedev.api.KodeTrainingApiFactory

object CompanyUserRepositoryFactory {
    fun create(): CompanyUserRepository = CompanyUserRepositoryImp(KodeTrainingApiFactory.create())
}