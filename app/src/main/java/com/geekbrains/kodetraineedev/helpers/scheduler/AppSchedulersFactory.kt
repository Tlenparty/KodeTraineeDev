package com.geekbrains.kodetraineedev.helpers.scheduler

object AppSchedulersFactory {
    fun create(): AppSchedulers = AppSchedulersImpl()
}