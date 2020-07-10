package com.doctoranywhere.patientmvvm.services.di

import com.doctoranywhere.patientmvvm.BuildConfig
import com.doctoranywhere.patientmvvm.services.retrofitclient.RetrofitApiInterface
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module(includes = [NetworkModule::class])
class ApiServiceModule {

    @Singleton
    @Provides
    internal fun provideRetrofitApi(client: OkHttpClient): RetrofitApiInterface {
        return createRetrofit(BuildConfig.BASE_URL, client, GsonConverterFactory.create())
            .create(RetrofitApiInterface::class.java!!)
    }



    private fun createRetrofit(
        baseUrl: String, okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }


}
