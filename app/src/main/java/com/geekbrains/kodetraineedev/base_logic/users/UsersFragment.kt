package com.geekbrains.kodetraineedev.base_logic.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geekbrains.kodetraineedev.App.Navigation.router
import com.geekbrains.kodetraineedev.base_logic.users.adapter.UserAdapter
import com.geekbrains.kodetraineedev.databinding.VpUsersFragmentBinding
import com.geekbrains.kodetraineedev.helpers.scheduler.AppSchedulersFactory
import com.geekbrains.kodetraineedev.model.repositories.company.CompanyUserRepositoryFactory
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, UserAdapter.Delegate {

    private val binding: VpUsersFragmentBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private val usersAdapter = UserAdapter(this)
    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            companyUserRepository = CompanyUserRepositoryFactory.create(),
            router = router,
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
        binding.rvUsers.adapter = usersAdapter
    }

    override fun startUpdateUsers() {
        //binding.progressBar2.visibility = View.GONE
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

    companion object {
        fun newInstance() = UsersFragment()
    }
}
