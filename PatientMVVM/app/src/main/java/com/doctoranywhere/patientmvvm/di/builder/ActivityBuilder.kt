package com.doctoranywhere.patientmvvm.di.builder

import com.doctoranywhere.patientmvvm.di.module.FragmentModule
import com.doctoranywhere.patientmvvm.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun bindMainActivity(): MainActivity

}