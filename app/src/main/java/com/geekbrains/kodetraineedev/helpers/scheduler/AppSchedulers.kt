package com.geekbrains.kodetraineedev.helpers.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

interface AppSchedulers {
    fun background(): Scheduler = io.reactivex.schedulers.Schedulers.newThread()
    fun main(): Scheduler = AndroidSchedulers.mainThread()
}