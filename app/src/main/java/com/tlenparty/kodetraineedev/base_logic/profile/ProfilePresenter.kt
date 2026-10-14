package com.tlenparty.kodetraineedev.base_logic.profile

import com.tlenparty.kodetraineedev.base_logic.BasePresenter
import com.tlenparty.kodetraineedev.base_logic.users.CompanyUsersViewModel
import com.tlenparty.kodetraineedev.helpers.scheduler.AppSchedulers
import com.github.terrakok.cicerone.Router

class ProfilePresenter(
    private val user: CompanyUsersViewModel?,
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