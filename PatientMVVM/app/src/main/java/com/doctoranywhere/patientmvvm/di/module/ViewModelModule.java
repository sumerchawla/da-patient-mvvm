package com.doctoranywhere.patientmvvm.di.module;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.doctoranywhere.patientmvvm.di.factory.DaggerViewModelFactory;
import com.doctoranywhere.patientmvvm.ui.viewmodel.LoginViewModel;
import com.doctoranywhere.patientmvvm.ui.viewmodel.SplashViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    public abstract ViewModelProvider.Factory bindDaggerViewModelFactory(DaggerViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel.class)
    public abstract ViewModel splashViewModel(SplashViewModel splashViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    public abstract ViewModel loginViewModel(LoginViewModel loginViewModel);

}