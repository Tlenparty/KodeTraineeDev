package com.geekbrains.kodetraineedev.base_logic.designers

import com.geekbrains.kodetraineedev.base_logic.ScreenView
import com.geekbrains.kodetraineedev.base_logic.users.CompanyUsersViewModel
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface DesignersView:ScreenView {
    fun showUsers(users: List<CompanyUsersViewModel>)
}