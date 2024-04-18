package com.example.mpesaintergration

import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

    lateinit var edtcontact:EditText
    lateinit var edtamount:EditText
    lateinit var Button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtamount = findViewById(R.id.edtamount)
        edtcontact = findViewById(R.id.edtcontact)
        Button = findViewById(R.id.btnSubmit)

        Button.setOnClickListener {
            loadCredentials()
        }

    }

    private fun loadCredentials() {
        var Amount  = edtamount.text.toString().toInt()
        var PartyA = edtamount.text.toString().toLong()
        var consumerKey:String = "EIlhAIx3vSPy5fV2ged4A5XFWJrPTK7H0lUjUs12sj03xWqt"
        var consumerSecret:String = "vVeyVizcspuAa7VZZEvkAocW2sHE7GpdvBSX04SSj9NHLkL5SZdgACIQRhA2beJw"

        val auth = "Basic " + Base64.encodeToString("$consumerKey:$consumerSecret".toByteArray(), Base64.NO_WRAP)

        AccesToken(
            Amount = Amount,
            PartyA = PartyA

        )

        var retrofit = Retrofit.Builder()
            .baseUrl("https://sandbox.safaricom.co.ke/")
            .build()
            .create(ApiService::class.java)

        retrofit.getCredential(auth).enqueue(object :Callback<AccesToken>{
            override fun onResponse(call: Call<AccesToken>, response: Response<AccesToken>) {
                if(response.isSuccessful){
                    val accessToken = response.body()
                    Log.d("mpesaApi", "Succesfull Api: ${accessToken}")
                }
            }

            override fun onFailure(call: Call<AccesToken>, t: Throwable) {
                Log.e("mpesaApi","errorApi :${t}")
            }

        })

    }
}