package com.geekbrains.kodetraineedev.base_logic.users

import com.geekbrains.kodetraineedev.base_logic.ScreenView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView : ScreenView {

    fun showUsers(users: List<CompanyUsersViewModel>)

    fun startUpdateUsers()

}