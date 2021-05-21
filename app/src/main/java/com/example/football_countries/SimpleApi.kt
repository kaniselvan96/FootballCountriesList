package com.example.football_countries

import retrofit2.Call
import retrofit2.http.GET

interface SimpleApi {

    @GET("countries?api_token=Dt0XBsc7sKdED1dZQ32jUIKQsDmnBdanLdGmbHlp5DQIRM7QAEfpy5QruUBp")
    fun getData(): Call<List<data>>
}