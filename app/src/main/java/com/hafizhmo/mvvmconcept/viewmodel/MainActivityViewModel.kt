package com.hafizhmo.mvvmconcept.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hafizhmo.mvvmconcept.repository.CharacterRepository
import com.hafizhmo.mvvmconcept.model.CharacterResponseItem

class MainActivityViewModel: ViewModel() {

    private var serviceLiveData: MutableLiveData<List<CharacterResponseItem>>? = null

    fun getCharacter(): LiveData<List<CharacterResponseItem>>? {
        serviceLiveData = CharacterRepository.getResponseApi()
        return serviceLiveData
    }

}