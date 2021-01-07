package com.onlinehowtodo.fragmenttest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class CheckOutViewModelFactory(val id: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CheckOutViewModel::class.java)) {
            return CheckOutViewModel(id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
