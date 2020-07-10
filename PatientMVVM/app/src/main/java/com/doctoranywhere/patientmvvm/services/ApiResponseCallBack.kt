package com.doctoranywhere.patientmvvm.services;


interface ApiResponseCallBack {
    fun onSuccess(value: Any, etag:String)
    fun onError(error: String, errorCode: Int)
    fun onNoNetwork(error: String)
}
