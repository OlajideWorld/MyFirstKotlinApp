package com.example.myfirstkotlinapp.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstkotlinapp.Adapter.HobbiesAdapter
import com.example.myfirstkotlinapp.R
import com.example.myfirstkotlinapp.Supplier

class Hobbies : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        setyourRecyclerView()
    }

    private fun setyourRecyclerView(){
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        var adapterManager = HobbiesAdapter(this, Supplier.hobbies)
        recyclerView.adapter = adapterManager

    }
}