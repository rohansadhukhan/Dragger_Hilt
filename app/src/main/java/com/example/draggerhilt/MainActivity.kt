package com.example.draggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint // we need to define entry point where to use dagger hilt
// for fragment we need to annotate in fragment as well as in parent activity
class MainActivity : AppCompatActivity() {

    @Inject // it search in AppModule and return the value to the variable
    // if we have many fun which return string it don't know the correct fun
    @Named("String1")
    lateinit var testString : String

    private val viewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "test string from main activity is $testString")
    }
}