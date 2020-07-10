package com.doctoranywhere.patientmvvm.services.retrofitclient;

import com.doctoranywhere.patientmvvm.services.model.response.auth.AuthTokenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface RetrofitApiInterface {

    @POST("auth")
    fun getAuthToken(@Body appName: String): Call<AuthTokenResponse>

}
