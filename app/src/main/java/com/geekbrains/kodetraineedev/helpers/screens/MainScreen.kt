package com.geekbrains.kodetraineedev.helpers.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.geekbrains.kodetraineedev.base_logic.main.MainFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class MainScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment = MainFragment.newInstance()
}