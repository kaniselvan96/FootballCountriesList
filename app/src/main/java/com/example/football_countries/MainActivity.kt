package com.example.football_countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMyData()
    }

    private fun getMyData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://soccer.sportmonks.com/api/v2.0/")
            .build()
            .create(SimpleApi::class.java)

        val retrofitData = retrofitBuilder.getData()
        println("Data: $retrofitData")

        retrofitData.enqueue(object : Callback<List<data>?> {
            override fun onResponse(call: Call<List<data>?>, response: Response<List<data>?>) {
                val responseBody = response.body()!!

                println("Data: $responseBody")

            }

            override fun onFailure(call: Call<List<data>?>, t: Throwable) {
                println("Error: Failed 1234")
            }
        })

    }
}