package com.geekbrains.kodetraineedev.base_logic.main

import com.geekbrains.kodetraineedev.base_logic.ScreenView
import com.geekbrains.kodetraineedev.databinding.ViewPagerBinding
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView:ScreenView {

    fun setViewPager2()
}