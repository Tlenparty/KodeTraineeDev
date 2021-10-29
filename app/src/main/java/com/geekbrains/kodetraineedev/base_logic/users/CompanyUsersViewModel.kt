package com.geekbrains.kodetraineedev.base_logic.users

import com.geekbrains.kodetraineedev.model.entities.CompanyUser

data class CompanyUsersViewModel(
    val firstName: String,
    val lastName:String,
    val department:String,
    val avatar: String
) {

    object Mapper {
        fun map(user: CompanyUser) =
            CompanyUsersViewModel(
                user.firstName.uppercase(),
                user.lastName,
                user.department,
                user.avatarUrl
            )
    }

}
