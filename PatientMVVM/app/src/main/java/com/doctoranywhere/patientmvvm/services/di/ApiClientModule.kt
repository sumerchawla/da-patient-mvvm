package com.doctoranywhere.patientmvvm.services.di

import android.content.Context
import com.allpoint.services.retrofitclient.*
import com.doctoranywhere.patientmvvm.services.retrofitclient.RetrofitClient
import com.doctoranywhere.patientmvvm.services.retrofitclient.RetrofitApiInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ApiServiceModule::class])
class ApiClientModule {

    @Provides
    @Singleton
    internal fun provideInternetHelper(context: Context): InternetHelper {
        return InternetHelper(context)
    }

    @Provides
    @Singleton
    internal fun provideApiRetrofitClient(
        context: Context,
        retrofitApiInterface: RetrofitApiInterface,
        internetHelper: InternetHelper
    ): RetrofitClient {
        return RetrofitClient(context, retrofitApiInterface, internetHelper)
    }

}