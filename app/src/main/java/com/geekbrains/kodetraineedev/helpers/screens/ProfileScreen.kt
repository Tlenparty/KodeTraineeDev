package com.geekbrains.kodetraineedev.helpers.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.geekbrains.kodetraineedev.base_logic.profile.ProfileFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ProfileScreen(private val bundle:Bundle):FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment = ProfileFragment.newInstance(bundle)

}