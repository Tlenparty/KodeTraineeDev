package com.tlenparty.kodetraineedev.base_logic.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tlenparty.kodetraineedev.App
import com.tlenparty.kodetraineedev.base_logic.users.CompanyUsersViewModel
import com.tlenparty.kodetraineedev.databinding.ProfileFragmentBinding
import com.tlenparty.kodetraineedev.helpers.extensions.setDrawableCircleImageFromUri
import com.tlenparty.kodetraineedev.helpers.scheduler.AppSchedulersFactory
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ProfileFragment : MvpAppCompatFragment(),ProfileView {

    private val binding: ProfileFragmentBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private val user by lazy { arguments?.getParcelable<CompanyUsersViewModel>(USER_ID)}
    private val presenter by moxyPresenter {
        ProfilePresenter(
            user,
            router = App.router
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        const val USER_ID = "id"
        fun newInstance(bundle: Bundle): Fragment = ProfileFragment()
            .also {
                it.arguments = bundle
            }
    }

    override fun showProfile(user: CompanyUsersViewModel)= with(binding) {
        tvName.text = user.firstName
        tvSurname.text = user.lastName
        tvDepartment.text = user.department
        tvBirthday.text = user.birthday
        tvPhone.text = user.phone
        ivAvatar.setDrawableCircleImageFromUri(user.avatar,ivAvatar)
    }

    override fun showError(error: Throwable) {
        TODO("Not yet implemented")
    }

}