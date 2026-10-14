package com.tlenparty.kodetraineedev.base_logic

import android.os.Bundle
import com.tlenparty.kodetraineedev.App.Navigation.navigatorHolder
import com.tlenparty.kodetraineedev.App.Navigation.router
import com.tlenparty.kodetraineedev.R
import com.tlenparty.kodetraineedev.helpers.screens.MainScreen
import com.tlenparty.kodetraineedev.helpers.screens.UsersScreen
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
        savedInstanceState ?: router.newRootScreen(MainScreen()) // UsersScreen()
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}