package com.geekbrains.kodetraineedev.base_logic.main

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geekbrains.kodetraineedev.databinding.BottomSheetLayoutBinding
import com.geekbrains.kodetraineedev.helpers.Constants
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment: BottomSheetDialogFragment() {
    private val binding: BottomSheetLayoutBinding by viewBinding(createMethod = CreateMethod.INFLATE)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rbAlphabet.setOnClickListener {
            setFilter(Constants.ALPHABET)
        }
        binding.rbBirthday.setOnClickListener {
            setFilter(Constants.BIRTHDAY)
        }
    }

    private fun setFilter(filer:Int){
        // TODO: 13.11.2021 =( 
    }

}