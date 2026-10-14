package com.tlenparty.kodetraineedev.helpers.extensions

import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.tlenparty.kodetraineedev.model.entities.CompanyUser
import com.tlenparty.kodetraineedev.model.entities.ItemsDTO

fun View.click(click: () -> Unit) = setOnClickListener { click() }

fun Fragment.arguments(vararg arguments: Pair<String, Any>): Fragment {
    this.arguments = bundleOf(*arguments)
    return this
}

fun convertItemsDtoToCompany(itemsDTO: ItemsDTO): List<CompanyUser> = itemsDTO.companyUser
