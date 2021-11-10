package com.geekbrains.kodetraineedev.base_logic.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geekbrains.kodetraineedev.App
import com.geekbrains.kodetraineedev.R
import com.geekbrains.kodetraineedev.base_logic.main.viewpager.ViewPagerAdapter2
import com.geekbrains.kodetraineedev.databinding.MainFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MainFragment : MvpAppCompatFragment(), MainView {

    private val binding: MainFragmentBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private val presenter by moxyPresenter {
        MainPresenter(
            router = App.router
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun setViewPager2() {
        binding.viewPagerLayout.apply {
            viewPager2.adapter = ViewPagerAdapter2(childFragmentManager,lifecycle)
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                tab.customView = when (position) {
                    1 -> layoutInflater.inflate(R.layout.vp_custom_tab_designers, null)
                    2 -> layoutInflater.inflate(R.layout.vp_custom_tab_analysts, null)
                    3 -> layoutInflater.inflate(R.layout.vp_custom_tab_managers, null)
                    else -> layoutInflater.inflate(R.layout.vp_custom_tab_users, null)
                }
            }.attach()
        }
    }

    override fun showError(error: Throwable) {
        TODO("Not yet implemented")
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}


