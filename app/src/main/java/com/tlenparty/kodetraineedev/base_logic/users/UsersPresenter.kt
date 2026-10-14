package com.tlenparty.kodetraineedev.base_logic.users

import android.os.Bundle
import com.tlenparty.kodetraineedev.base_logic.BasePresenter
import com.tlenparty.kodetraineedev.base_logic.profile.ProfileFragment
import com.tlenparty.kodetraineedev.helpers.extensions.convertItemsDtoToCompany
import com.tlenparty.kodetraineedev.helpers.scheduler.AppSchedulers
import com.tlenparty.kodetraineedev.helpers.screens.ProfileScreen
import com.tlenparty.kodetraineedev.model.repositories.company.CompanyUserRepository
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