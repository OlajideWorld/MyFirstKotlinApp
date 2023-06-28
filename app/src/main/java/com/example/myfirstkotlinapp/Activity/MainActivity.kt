package com.example.myfirstkotlinapp.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstkotlinapp.Constants.showToastMessage
import com.example.myfirstkotlinapp.R


class MainActivity : AppCompatActivity() {

    companion object {
        var TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var newButton = findViewById<Button>(R.id.ShowYourMessageIntent)
        var getMessage = findViewById<EditText>(R.id.EnterMessage)


        newButton.setOnClickListener{
            var message = getMessage.text.toString()
            Log.i(TAG,"Button 1 was clicked")
        showToastMessage(message)

            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("show_message",resources.getString(R.string.default_message))
            startActivity(intent)
        }

        var anotherButton = findViewById<Button>(R.id.sendYourMessage)
        anotherButton.setOnClickListener{
            var messsage = findViewById<EditText>(R.id.EnterMessage)
            var newMessage = messsage.text.toString()

            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("show_message",newMessage)
            startActivity(intent)
        }

        var implicitButton = findViewById<Button>(R.id.implicitMessage)
        var message2 = findViewById<EditText>(R.id.EnterMessage)
        implicitButton.setOnClickListener{
            var message3 = message2.text.toString()
            var intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,message3)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent,"Choose who to share with"))
        }

        var recyclerButton = findViewById<Button>(R.id.hobbiesButton)
        recyclerButton.setOnClickListener{
            var intent = Intent(this, Hobbies::class.java)
            startActivity(intent)
        }
    }
}