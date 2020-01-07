package com.uma.basicretrofit.ui.carlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uma.basicretrofit.data.DataItem
import com.uma.basicretrofit.data.Repository
import kotlinx.coroutines.launch

/**
 * Created by Umapathi on 2020-01-07.
 * Copyright Indyzen Inc, @2020
 */
class CarListViewModel : ViewModel() {

    val repository : Repository by lazy { Repository() }

    private val _list = MutableLiveData<List<DataItem>>()
    var list : LiveData<List<DataItem>> = _list
    /**
     * gettingcar list...
     */
    fun checkWebService(){
        viewModelScope.launch {
            _list.postValue(repository.getList())
        }
    }
}