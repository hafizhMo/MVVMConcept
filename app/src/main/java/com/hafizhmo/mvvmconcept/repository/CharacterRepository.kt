package com.hafizhmo.mvvmconcept.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.hafizhmo.mvvmconcept.model.CharacterResponseItem
import com.hafizhmo.mvvmconcept.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object CharacterRepository {

    val characterResponse = MutableLiveData<List<CharacterResponseItem>>()

    fun getResponseApi(): MutableLiveData<List<CharacterResponseItem>> {

        val call = RetrofitClient.harryPotterApi.getCharacters()

        call.enqueue(object : Callback<List<CharacterResponseItem>> {
            override fun onResponse(
                call: Call<List<CharacterResponseItem>>,
                response: Response<List<CharacterResponseItem>>
            ) {
                Log.v("Debug: ", response.body().toString())

                val data = response.body()!!

                characterResponse.value = data
            }

            override fun onFailure(call: Call<List<CharacterResponseItem>>, t: Throwable) {
                Log.v("Debug: ", t.message.toString())
            }

        })

        return characterResponse
    }
}