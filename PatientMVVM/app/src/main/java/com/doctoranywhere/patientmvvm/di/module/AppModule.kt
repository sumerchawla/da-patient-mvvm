package com.doctoranywhere.patientmvvm.di.module

import android.app.Application
import android.content.Context
import com.doctoranywhere.patientmvvm.services.di.ApiClientModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ApiClientModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application

}