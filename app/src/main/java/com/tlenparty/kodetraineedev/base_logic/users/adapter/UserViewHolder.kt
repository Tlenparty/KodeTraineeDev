package com.tlenparty.kodetraineedev.base_logic.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tlenparty.kodetraineedev.base_logic.users.CompanyUsersViewModel
import com.tlenparty.kodetraineedev.databinding.UsersRecyclerItemFragmentBinding
import com.tlenparty.kodetraineedev.helpers.extensions.click
import com.tlenparty.kodetraineedev.helpers.extensions.setDrawableCircleImageFromUri

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val viewBinding: UsersRecyclerItemFragmentBinding by viewBinding()

    fun bind(user: CompanyUsersViewModel, delegate: UserAdapter.Delegate?) {
        with(viewBinding) {
            tvName.text = user.firstName
            tvSurname.text = user.lastName
            tvDepartment.text= user.department
            ivAvatar.setDrawableCircleImageFromUri(user.avatar,ivAvatar)

            root.click { delegate?.onUserPicked(user) }
        }
    }

}