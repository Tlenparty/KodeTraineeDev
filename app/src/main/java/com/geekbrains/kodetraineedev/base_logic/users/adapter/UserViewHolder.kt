package com.geekbrains.kodetraineedev.base_logic.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geekbrains.kodetraineedev.base_logic.users.CompanyUsersViewModel
import com.geekbrains.kodetraineedev.databinding.FragmentUsersRecyclerItemBinding
import com.geekbrains.kodetraineedev.helpers.extensions.click

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val viewBinding: FragmentUsersRecyclerItemBinding by viewBinding()

    fun bind(user: CompanyUsersViewModel, delegate: UserAdapter.Delegate?) {
        with(viewBinding) {
            tvName.text = user.firstName
            tvSurname.text = user.lastName
            tvDeparture.text= user.department

            root.click { delegate?.onUserPicked(user) }
        }
    }

}