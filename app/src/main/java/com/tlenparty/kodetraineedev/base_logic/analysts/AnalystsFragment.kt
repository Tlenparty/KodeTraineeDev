package com.tlenparty.kodetraineedev.base_logic.analysts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tlenparty.kodetraineedev.App
import com.tlenparty.kodetraineedev.base_logic.users.CompanyUsersViewModel
import com.tlenparty.kodetraineedev.base_logic.users.adapter.UserAdapter
import com.tlenparty.kodetraineedev.databinding.VpAnalystsFragmentBinding
import com.tlenparty.kodetraineedev.helpers.scheduler.AppSchedulersFactory
import com.tlenparty.kodetraineedev.model.repositories.company.CompanyUserRepositoryFactory
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class AnalystsFragment : MvpAppCompatFragment(), AnalystsView, UserAdapter.Delegate {

    private val binding: VpAnalystsFragmentBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private val usersAdapter = UserAdapter(this)
    private val presenter: AnalystsPresenter by moxyPresenter {
        AnalystsPresenter(
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

