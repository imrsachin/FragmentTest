package com.onlinehowtodo.fragmenttest

import androidx.lifecycle.ViewModel

class CheckOutViewModel(id: Int) : ViewModel() {
    val product = products.find { it.id == id }
    private var _qty = 1

    val qty: Int
        get() = _qty

    fun addQty() {
        _qty++
    }

    fun reduceQty() {
        if (_qty - 1 > 0) {
            _qty--
        }
    }

}