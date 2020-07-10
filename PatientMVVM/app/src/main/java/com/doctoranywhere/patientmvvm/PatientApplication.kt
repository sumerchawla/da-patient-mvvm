package com.doctoranywhere.patientmvvm

import com.doctoranywhere.patientmvvm.di.component.DaggerAppComponent
import dagger.android.DaggerApplication


class PatientApplication:DaggerApplication(){

    private val appComponent = DaggerAppComponent.factory().create(this)

    override fun applicationInjector() = appComponent


}