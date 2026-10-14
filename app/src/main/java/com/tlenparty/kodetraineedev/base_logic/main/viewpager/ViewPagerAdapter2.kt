package com.tlenparty.kodetraineedev.base_logic.main.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tlenparty.kodetraineedev.base_logic.analysts.AnalystsFragment
import com.tlenparty.kodetraineedev.base_logic.designers.DesignersFragment
import com.tlenparty.kodetraineedev.base_logic.managers.ManagerFragment
import com.tlenparty.kodetraineedev.base_logic.users.UsersFragment
import com.tlenparty.kodetraineedev.helpers.Constants

class ViewPagerAdapter2(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = Constants.COUNT_TAB_FRAGMENTS

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> DesignersFragment()
            2 -> AnalystsFragment()
            3 -> ManagerFragment()
            else -> UsersFragment()
        }
    }

}