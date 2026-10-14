package com.tlenparty.kodetraineedev.base_logic.managers

import com.tlenparty.kodetraineedev.base_logic.ScreenView
import com.tlenparty.kodetraineedev.base_logic.users.CompanyUsersViewModel
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ManagerView:ScreenView {
    fun showUsers(users: List<CompanyUsersViewModel>)
}