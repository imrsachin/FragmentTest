package com.onlinehowtodo.fragmenttest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CheckOutViewModel(id: Int) : ViewModel() {
    private val _product = MutableLiveData<Product>(products.find { it.id == id })

    val product: LiveData<Product>
        get() = _product


    private var _qty = MutableLiveData<Int>(1)
    val qty: LiveData<Int>
        get() = _qty


    fun addQty() {
        _qty.value?.let {
            _qty.value = it+1
        }
    }

    fun reduceQty() {
        _qty.value?.let {
            if(it-1>1){
                _qty.value = it-1
            }
        }
    }

}