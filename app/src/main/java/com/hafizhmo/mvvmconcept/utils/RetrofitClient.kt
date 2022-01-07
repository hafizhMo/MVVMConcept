package com.hafizhmo.mvvmconcept.utils

import com.hafizhmo.mvvmconcept.utils.HarryPotterApi.Companion.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {

    private val retrofitClient: Retrofit.Builder by lazy {

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
    }

    val harryPotterApi: HarryPotterApi by lazy {
        retrofitClient
            .build()
            .create(HarryPotterApi::class.java)
    }

}