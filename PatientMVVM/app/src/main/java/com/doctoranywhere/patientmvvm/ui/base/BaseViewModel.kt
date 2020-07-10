package com.doctoranywhere.patientmvvm.ui.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>: ViewModel() {

    private val isLoading = ObservableBoolean(false)
    private lateinit var mNavigator: WeakReference<N>

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

    fun getNavigator(): N? = mNavigator.get()

    fun setNavigator(navigator: N) {
        this.mNavigator = WeakReference(navigator)
    }
}