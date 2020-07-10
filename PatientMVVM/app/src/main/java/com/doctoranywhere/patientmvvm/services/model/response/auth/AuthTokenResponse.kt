package com.doctoranywhere.patientmvvm.services.model.response.auth

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuthTokenResponse {
    @SerializedName("token")
    @Expose
    var token: String? = null

}