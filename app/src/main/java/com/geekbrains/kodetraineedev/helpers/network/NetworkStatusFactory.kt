package com.geekbrains.kodetraineedev.helpers.network

import android.content.Context

object NetworkStatusFactory {
    fun create(context: Context):NetworkStatus = NetWorkStatusImpl(context)
}