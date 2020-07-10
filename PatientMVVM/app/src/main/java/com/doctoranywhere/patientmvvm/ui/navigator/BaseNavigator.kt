package com.doctoranywhere.patientmvvm.ui.navigator


interface BaseNavigator {
    fun handleSuccess(message: String)
    fun handleError(throwable: Throwable)
}