package com.geekbrains.kodetraineedev.base_logic.users

import android.os.Bundle
import com.geekbrains.kodetraineedev.base_logic.BasePresenter
import com.geekbrains.kodetraineedev.base_logic.profile.ProfileFragment
import com.geekbrains.kodetraineedev.helpers.extensions.convertItemsDtoToCompany
import com.geekbrains.kodetraineedev.helpers.scheduler.AppSchedulers
import com.geekbrains.kodetraineedev.helpers.screens.ProfileScreen
import com.geekbrains.kodetraineedev.model.repositories.company.CompanyUserRepository
import com.github.terrakok.cicerone.Router
import io.reactivex.rxkotlin.plusAssign

class UsersPresenter(
    private val companyUserRepository: CompanyUserRepository,
    private val appSchedulers: AppSchedulers,
    router: Router
) : BasePresenter<UsersView>(router) {

    override fun onFirstViewAttach() {
        loadData()
    }

    private fun loadData() {
        disposables +=
            companyUserRepository
                .getUsersFromServer()
                .observeOn(appSchedulers.background())
                .map { convertItemsDtoToCompany(it) }
                .map { users -> users.map(CompanyUsersViewModel.Mapper::map) }
                .observeOn(appSchedulers.main())
                .subscribeOn(appSchedulers.background())
                .subscribe(
                    viewState::showUsers,
                    viewState::showError
                )
    }

    fun displayProfile(user: CompanyUsersViewModel) {
        val bundle = Bundle().apply {
            putParcelable(ProfileFragment.USER_ID, user)
        }
        router.navigateTo(ProfileScreen(bundle))
    }

    override fun onDestroy() {
        disposables.dispose()
    }
}