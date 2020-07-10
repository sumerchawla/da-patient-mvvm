package com.doctoranywhere.patientmvvm.services.retrofitclient

import android.content.Context
import com.allpoint.services.retrofitclient.InternetHelper
import com.doctoranywhere.patientmvvm.services.ApiResponseCallBack
import com.doctoranywhere.patientmvvm.services.model.response.auth.AuthTokenResponse
import com.doctoranywhere.patientmvvm.utils.Constants
import com.doctoranywhere.patientmvvm.utils.Constants.API_INTERNAL_ERROR
import com.doctoranywhere.patientmvvm.utils.Constants.API_SUCCESS

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetrofitClient @Inject
constructor(
    private val context: Context,
    private val retrofitApiInterface: RetrofitApiInterface,
    private val internetHelper: InternetHelper
) {
    companion object {
        private val TAG = RetrofitClient::class.java.simpleName
    }

    fun getAuthToken(userId: String, callBack: ApiResponseCallBack) {

        if(internetHelper.isInternetConnected()) {
            val call = retrofitApiInterface.getAuthToken(userId)
            call.enqueue(object : Callback<AuthTokenResponse> {
                override fun onFailure(call: Call<AuthTokenResponse>, t: Throwable) {
                    t.message?.let {
                        callBack.onError(it, API_INTERNAL_ERROR)
                    }

                }

                override fun onResponse(
                    call: Call<AuthTokenResponse>,
                    response: Response<AuthTokenResponse>
                ) {

                    if (response.code() == API_SUCCESS) {
                        response.body()?.let {
                            callBack!!.onSuccess(it,"")
                        }
                    } else {
                        callBack.onError(response.message(), response.code())
                    }
                }

            })
        }else{
            callBack.onNoNetwork(Constants.NO_INTERNET)
        }

    }



}