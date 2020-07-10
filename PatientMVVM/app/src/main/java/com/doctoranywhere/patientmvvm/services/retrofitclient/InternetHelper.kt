package com.doctoranywhere.patientmvvm.services.retrofitclient;

import android.content.Context;
import android.net.ConnectivityManager;

import javax.inject.Inject;

 class InternetHelper @Inject constructor(val context:Context) {


     fun isInternetConnected():Boolean {
         val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
