package com.doctoranywhere.patientmvvm.ui.viewmodel

import com.doctoranywhere.patientmvvm.services.ApiResponseCallBack
import com.doctoranywhere.patientmvvm.ui.base.BaseViewModel
import com.doctoranywhere.patientmvvm.ui.business.repository.LoginRepository
import com.doctoranywhere.patientmvvm.ui.business.usecase.LoginUsecase
import com.doctoranywhere.patientmvvm.ui.navigator.LoginNavigator
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginUsecase: LoginUsecase, private val loginRepository: LoginRepository): BaseViewModel<LoginNavigator>(),
    ApiResponseCallBack {


    override fun onSuccess(value: Any, etag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(error: String, errorCode: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNoNetwork(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    fun getAuthToken(){
        loginUsecase.getLogin("",this)
    }
}
