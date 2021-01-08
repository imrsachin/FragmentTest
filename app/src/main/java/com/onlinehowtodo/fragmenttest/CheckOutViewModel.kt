package com.onlinehowtodo.fragmenttest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.util.*

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
    val productPrice:LiveData<Float> =Transformations.map(_qty){
        return@map _product.value!!.price *  it
    }

    val trimDesc:LiveData<String> = Transformations.map(_product){
        return@map it.longDescription.substring(0,50).toUpperCase(Locale.getDefault())
    }

    fun reduceQty() {
        _qty.value?.let {
            if(it-1>0){
                _qty.value = it-1
            }
        }
    }

}