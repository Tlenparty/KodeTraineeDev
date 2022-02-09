package com.geekbrains.kodetraineedev.base_logic.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geekbrains.kodetraineedev.App
import com.geekbrains.kodetraineedev.R
import com.geekbrains.kodetraineedev.base_logic.main.viewpager.ViewPagerAdapter2
import com.geekbrains.kodetraineedev.databinding.MainFragmentBinding
import com.geekbrains.kodetraineedev.helpers.scheduler.AppSchedulersFactory
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.internal.TextWatcherAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.textfield.TextInputLayout
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import timber.log.Timber
import java.util.concurrent.TimeUnit

class MainFragment : MvpAppCompatFragment(), MainView {

    private val binding: MainFragmentBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private val presenter by moxyPresenter {
        MainPresenter(
            appSchedulers = AppSchedulersFactory.create(),
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

    override fun setEndIconListener()= with(binding) {
        tiLayout.setEndIconOnClickListener {
            val fragment = BottomSheetFragment()
            fragment.listener = {
                Toast.makeText(context, "$it",Toast.LENGTH_SHORT).show()
                fragment.dismiss()
            }
            fragment.show(childFragmentManager,null)
        }
    }

    override fun setViewPager2() {
        binding.viewPagerLayout.apply {
            viewPager2.adapter = ViewPagerAdapter2(childFragmentManager, lifecycle)
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                tab.customView = when (position) {
                    1 -> layoutInflater.inflate(R.layout.vp_custom_tab_designers, null)
                    2 -> layoutInflater.inflate(R.layout.vp_custom_tab_analysts, null)
                    3 -> layoutInflater.inflate(R.layout.vp_custom_tab_managers, null)
                    else -> layoutInflater.inflate(R.layout.vp_custom_tab_users, null)
                }
            }.attach()
        }
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

  /*  @SuppressLint("CheckResult")
    private fun search() {
        Observable.create<String> { emitter ->
            binding.etSearch.textListe(@SuppressLint("CheckResult")
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (!emitter.isDisposed) {
                        newText?.let { emitter.onNext(it) }
                    }
                    return false
                }
            })
        }
            .debounce(1000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.d("Search: " + it)
                    println("VVV Search$it")

                },
                {
                    Timber.e("Error: " + it)
                },
                {
                    Timber.d("Complete")
                }

            )
    }
*/

    companion object {
        fun newInstance() = MainFragment()
    }
}


