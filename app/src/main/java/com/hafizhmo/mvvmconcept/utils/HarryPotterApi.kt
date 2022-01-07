package com.hafizhmo.mvvmconcept.utils

import com.hafizhmo.mvvmconcept.model.CharacterResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface HarryPotterApi {

    @GET("characters")
    fun getCharacters(): Call<List<CharacterResponseItem>>

    companion object{
        const val BASE_URL = "http://hp-api.herokuapp.com/api/"
    }

}