package com.geekbrains.kodetraineedev.base_logic.users.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.geekbrains.kodetraineedev.base_logic.users.CompanyUsersViewModel

object UserDiff : DiffUtil.ItemCallback<CompanyUsersViewModel>() {

    private val payload = Any()

    override fun areItemsTheSame(
        oldItem: CompanyUsersViewModel,
        newItem: CompanyUsersViewModel
    ): Boolean {
        return oldItem.firstName == newItem.firstName
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: CompanyUsersViewModel,
        newItem: CompanyUsersViewModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: CompanyUsersViewModel, newItem: CompanyUsersViewModel) =
        payload
}