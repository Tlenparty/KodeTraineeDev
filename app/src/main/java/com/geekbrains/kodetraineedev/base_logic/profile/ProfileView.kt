package com.geekbrains.kodetraineedev.base_logic.profile

import com.geekbrains.kodetraineedev.base_logic.ScreenView
import com.geekbrains.kodetraineedev.base_logic.users.CompanyUsersViewModel
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileView : ScreenView {

    fun showProfile(user: CompanyUsersViewModel)
}