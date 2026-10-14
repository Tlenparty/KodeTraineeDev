package com.tlenparty.kodetraineedev.helpers.scheduler

object AppSchedulersFactory {
    fun create(): AppSchedulers = AppSchedulersImpl()
}