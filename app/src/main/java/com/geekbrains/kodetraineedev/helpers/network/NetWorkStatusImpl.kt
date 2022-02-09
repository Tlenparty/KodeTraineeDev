package com.geekbrains.kodetraineedev.helpers.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject

class xNetWorkStatusImpl(context: Context) : NetworkStatus {

    private val statusSubject: BehaviorSubject<Boolean> = BehaviorSubject.create()
    private val networkCallback: ConnectivityManager.NetworkCallback
    private val connectivityManager: ConnectivityManager

    init {
        // По умолчанию будет отдавать что сети нет
        statusSubject.onNext(false)
        networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                statusSubject.onNext(true)
            }

            override fun onLost(network: Network) {
                statusSubject.onNext(true)
            }

            override fun onUnavailable() {
                statusSubject.onNext(false)
            }
        }
        connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val request = NetworkRequest.Builder().build()
        connectivityManager.registerNetworkCallback(request, networkCallback)
    }

    override fun isOnline(): Observable<Boolean> = statusSubject
    override fun isOnlineSingle(): Single<Boolean> = statusSubject.first(false)
    override fun unBind() = connectivityManager.unregisterNetworkCallback(networkCallback)

}