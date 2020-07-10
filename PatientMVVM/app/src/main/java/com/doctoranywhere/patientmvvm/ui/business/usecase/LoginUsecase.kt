package com.doctoranywhere.patientmvvm.ui.business.usecase

import com.doctoranywhere.patientmvvm.services.ApiResponseCallBack
import com.doctoranywhere.patientmvvm.services.retrofitclient.RetrofitClient
import javax.inject.Inject

class LoginUsecase @Inject constructor(private val retrofitClient: RetrofitClient) {

    fun getLogin(userId:String,
        callback: ApiResponseCallBack
    ) {
        retrofitClient!!.getAuthToken(userId,callback)
    }

}