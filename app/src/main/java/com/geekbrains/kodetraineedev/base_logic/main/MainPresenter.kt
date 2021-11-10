package com.geekbrains.kodetraineedev.base_logic.main

import com.geekbrains.kodetraineedev.base_logic.BasePresenter
import com.github.terrakok.cicerone.Router

class MainPresenter(
    router: Router
) : BasePresenter<MainView>(router) {

    override fun onFirstViewAttach() {
        showViewPager()
    }

    private fun showViewPager(){
      viewState.setViewPager2()
    }
}