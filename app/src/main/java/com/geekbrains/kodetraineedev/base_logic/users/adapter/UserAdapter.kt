package com.geekbrains.kodetraineedev.base_logic.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.geekbrains.kodetraineedev.R
import com.geekbrains.kodetraineedev.base_logic.users.CompanyUsersViewModel

class UserAdapter(private val delegate: Delegate?) :
    ListAdapter<CompanyUsersViewModel, UserViewHolder>(UserDiff) {

    interface Delegate {
        /**
         * Событие наступает при выборе
         * пользователя из списка.
         */
        fun onUserPicked(user: CompanyUsersViewModel)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.fragment_users_recycler_item, parent, false)
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)

}