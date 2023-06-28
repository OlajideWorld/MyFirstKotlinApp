package com.example.myfirstkotlinapp.Activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstkotlinapp.Constants.showToastMessage
import com.example.myfirstkotlinapp.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.secondactivity)

        var seconButton = findViewById<Button>(R.id.secondButton)
        var message : String? = ""

        seconButton.setOnClickListener{
            showToastMessage(resources.getString(R.string.secondActivity_btn_toast))
        }

        var bundle: Bundle? = intent.extras

        bundle?.let {
             message = bundle.getString("show_message")
        }

        var textview = findViewById<TextView>(R.id.ViewYourText)
        textview.text = message ?: "No Message"
    }
}