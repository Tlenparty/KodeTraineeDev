package com.geekbrains.kodetraineedev.base_logic.main

import com.geekbrains.kodetraineedev.base_logic.BasePresenter
import com.geekbrains.kodetraineedev.helpers.scheduler.AppSchedulers
import com.github.terrakok.cicerone.Router
import io.reactivex.Observable

class MainPresenter(
    private val appSchedulers: AppSchedulers,
    router: Router
) : BasePresenter<MainView>(router) {

    override fun onFirstViewAttach() {
        setEndIconClickListener()
        showViewPager()
    }

    private fun showViewPager(){
      viewState.setViewPager2()
    }

    private fun setEndIconClickListener(){
        viewState.setEndIconListener()
    }
}