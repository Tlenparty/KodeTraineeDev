package com.geekbrains.kodetraineedev.helpers.network

import io.reactivex.Observable
import io.reactivex.Single

interface NetworkStatus {
    fun isOnline(): Observable<Boolean>
    fun isOnlineSingle(): Single<Boolean>
    fun unBind()
}