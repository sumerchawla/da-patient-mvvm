package com.doctoranywhere.patientmvvm.di.module

import com.doctoranywhere.patientmvvm.ui.fragment.LoginFragment
import com.doctoranywhere.patientmvvm.ui.fragment.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun provideSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun provideLoginFragment(): LoginFragment

}