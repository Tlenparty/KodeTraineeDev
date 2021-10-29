package com.geekbrains.kodetraineedev.base_logic.main

import android.os.Bundle
import com.geekbrains.kodetraineedev.App.Navigation.navigatorHolder
import com.geekbrains.kodetraineedev.App.Navigation.router
import com.geekbrains.kodetraineedev.R
import com.geekbrains.kodetraineedev.helpers.screens.UsersScreen
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity() {
    private val navigator = AppNavigator(this, R.id.container)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        savedInstanceState ?: router.newRootScreen(UsersScreen())
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}