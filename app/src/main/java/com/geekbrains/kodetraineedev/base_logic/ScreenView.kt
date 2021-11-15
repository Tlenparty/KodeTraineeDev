package com.geekbrains.kodetraineedev.base_logic

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface ScreenView:MvpView {
    @SingleState
    fun showError(error: Throwable)
}