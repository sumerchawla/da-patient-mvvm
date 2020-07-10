package com.doctoranywhere.patientmvvm.ui.navigator


interface LoginNavigator {
    fun onError(throwable: Throwable)
    fun onSuccess()
}