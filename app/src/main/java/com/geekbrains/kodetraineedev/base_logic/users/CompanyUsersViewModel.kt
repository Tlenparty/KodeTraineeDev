package com.geekbrains.kodetraineedev.base_logic.users

import android.annotation.SuppressLint
import android.os.Build
import android.os.Parcelable
import androidx.annotation.RequiresApi
import com.geekbrains.kodetraineedev.model.entities.CompanyUser
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Parcelize
data class CompanyUsersViewModel(
    val id: String,
    val firstName: String,
    val lastName: String,
    val department: String,
    val avatar: String,
    val birthday: String,
    val phone: String,
) : Parcelable {
// "birthday": "2004-08-02",
    object Mapper {
        fun map(user: CompanyUser): CompanyUsersViewModel {
            val dateFormatter = SimpleDateFormat("yyyy-MM-dd",Locale.getDefault())
                .parse(user.birthday)
                .toString()
            return CompanyUsersViewModel(
                user.id,
                user.firstName,
                user.lastName,
                user.department,
                user.avatarUrl,
                dateFormatter,
                user.phone
            )
        }

    }

}
