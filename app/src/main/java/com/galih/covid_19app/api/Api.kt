package com.galih.covid_19app.api

import com.galih.covid_19app.model.IndonesiaResponse
import com.galih.covid_19app.model.ProvinceResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("indonesia")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET("indonesia/provinsi")
    fun getProvince(): Call<ArrayList<ProvinceResponse>>
}