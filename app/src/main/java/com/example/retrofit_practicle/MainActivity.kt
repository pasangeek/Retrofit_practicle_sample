package com.example.retrofit_practicle

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        textView = findViewById(R.id.textViewserviceCall)
        button.setOnClickListener {
            getUsers()
        }

    }

    private fun getUsers() {


        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)

        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val response = apiInterface.getUsers()
                if (response.isSuccessful) {
                    val userResponse = response.body()
                    Log.i("LNBTI", "${userResponse.toString()}")
                    withContext(Dispatchers.Main){
                    textView.text = userResponse.toString()
                    }
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (e:Exception){

                Log.e("Error",e.localizedMessage)
            }


        }


    }
}