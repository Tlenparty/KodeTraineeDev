package com.geekbrains.kodetraineedev.base_logic.managers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geekbrains.kodetraineedev.App
import com.geekbrains.kodetraineedev.base_logic.designers.DesignersPresenter
import com.geekbrains.kodetraineedev.base_logic.designers.DesignersView
import com.geekbrains.kodetraineedev.base_logic.users.CompanyUsersViewModel
import com.geekbrains.kodetraineedev.base_logic.users.adapter.UserAdapter
import com.geekbrains.kodetraineedev.databinding.VpDesignersFragmentBinding
import com.geekbrains.kodetraineedev.databinding.VpManagersFragmentBinding
import com.geekbrains.kodetraineedev.helpers.scheduler.AppSchedulersFactory
import com.geekbrains.kodetraineedev.model.repositories.company.CompanyUserRepositoryFactory
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ManagerFragment : MvpAppCompatFragment(), ManagerView, UserAdapter.Delegate {

    private val binding: VpManagersFragmentBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private val usersAdapter = UserAdapter(this)
    private val presenter: ManagerPresenter by moxyPresenter {
       ManagerPresenter(
            companyUserRepository = CompanyUserRepositoryFactory.create(),
            router = App.router,
            appSchedulers = AppSchedulersFactory.create()
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
        presenter.loadData()
        binding.rvUsers.adapter = usersAdapter
    }

    override fun showUsers(users: List<CompanyUsersViewModel>) {
        usersAdapter.submitList(users)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

    override fun onUserPicked(user: CompanyUsersViewModel) {
        presenter.displayProfile(user)
    }

}