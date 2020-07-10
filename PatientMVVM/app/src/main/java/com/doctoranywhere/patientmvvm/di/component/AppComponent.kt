package com.doctoranywhere.patientmvvm.di.component

import android.app.Application
import com.doctoranywhere.patientmvvm.di.module.ViewModelModule
import com.doctoranywhere.patientmvvm.di.builder.ActivityBuilder
import com.doctoranywhere.patientmvvm.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
                      AppModule::class,
                      ActivityBuilder::class,
                      ViewModelModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

}