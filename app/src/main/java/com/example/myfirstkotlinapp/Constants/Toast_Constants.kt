package com.example.myfirstkotlinapp.Constants

import android.app.Activity
import android.content.Context
import android.widget.Toast

fun Context.showToastMessage(message: String, duration : Int = Toast.LENGTH_SHORT) {
  return  Toast.makeText(this,message,duration).show()
}