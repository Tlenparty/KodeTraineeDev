package com.tlenparty.kodetraineedev.base_logic.main

import com.tlenparty.kodetraineedev.base_logic.ScreenView
import com.tlenparty.kodetraineedev.databinding.ViewPagerBinding
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView:ScreenView {
    fun setEndIconListener()
    fun setViewPager2()
}