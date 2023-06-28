package com.example.myfirstkotlinapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstkotlinapp.Constants.showToastMessage
import com.example.myfirstkotlinapp.Hobby
import com.example.myfirstkotlinapp.R

class HobbiesAdapter(val context: Context, val hobbies : List<Hobby>):
    RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      var viewlayout = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return  MyViewHolder(viewlayout)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
     val hobby = hobbies[position]
     holder.saveNewData(hobby,position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentHobby : Hobby? = null
        var currentPosition : Int = 0

        init {
            itemView.setOnClickListener{

                currentHobby?.let {
                    context.showToastMessage(currentHobby!!.title +" Clicked",Toast.LENGTH_LONG)
                }

            }

            itemView.findViewById<ImageView>(R.id.imageShare).setOnClickListener{
                var intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_INTENT,currentHobby!!.title)
                intent.type = "text/plain"

                context.startActivity(Intent.createChooser(intent,"Please choose App"))
            }
        }


        fun saveNewData(hobby: Hobby?, pos : Int){
            itemView.findViewById<TextView>(R.id.txtViews).text = hobby!!.title
            this.currentHobby = hobby
            this.currentPosition = pos
        }

    }



}