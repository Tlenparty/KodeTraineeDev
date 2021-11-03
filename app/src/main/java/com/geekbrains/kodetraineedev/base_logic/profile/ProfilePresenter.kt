package com.geekbrains.kodetraineedev.base_logic.profile

import com.geekbrains.kodetraineedev.base_logic.BasePresenter
import com.geekbrains.kodetraineedev.base_logic.users.CompanyUsersViewModel
import com.geekbrains.kodetraineedev.helpers.scheduler.AppSchedulers
import com.github.terrakok.cicerone.Router

class ProfilePresenter(
    private val user: CompanyUsersViewModel?,
    private val appSchedulers: AppSchedulers,
    router: Router
):BasePresenter<ProfileView>(router) {

    override fun onFirstViewAttach() {
        loadData()
    }

    private fun loadData(){
        user?.let {
            viewState.showProfile(it)
        }
    }

}