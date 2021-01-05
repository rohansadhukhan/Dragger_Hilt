package com.example.draggerhilt

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import javax.inject.Named

class TestViewModel @ViewModelInject constructor(
    @Named("String2") testString2 : String
)  : ViewModel() {

    init {
        Log.d("ViewModel", "Test string from view model - $testString2")
    }

}