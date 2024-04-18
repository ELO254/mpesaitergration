package com.example.mpesaintergration

import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("oauth/v1/generate?grant_type=client_credentials")

    fun getCredential(@Header("Authorization") auth: String): Call<AccesToken>
}