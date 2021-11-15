package com.geekbrains.kodetraineedev.base_logic

import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter
import moxy.MvpView

open class BasePresenter<T: MvpView> (protected val router: Router): MvpPresenter<T>() {

     protected  val disposables = CompositeDisposable()

     override fun onDestroy() {
         super.onDestroy()
         disposables.clear()
     }

     fun backPressed(): Boolean {
         router.exit()
         return true
     }
 }