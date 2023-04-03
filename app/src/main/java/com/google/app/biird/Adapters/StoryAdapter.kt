package com.google.app.biird.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.app.biird.Models.StoryModel
import com.google.app.biird.R

class StoryAdapter(val context : Context, val list : ArrayList<StoryModel>):RecyclerView.Adapter<StoryAdapter.StroyHolder>() {

    class StroyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val img=itemView.findViewById<ImageView>(R.id.storyI)
        val sn=itemView.findViewById<TextView>(R.id.sname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StroyHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.sample_story,parent,false)
        return StroyHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: StroyHolder, position: Int) {
        val st:StoryModel=list.get(position)
        holder.img.setImageResource(st.simg)
        if(position==0) holder.sn.text="Your Story"
        else holder.sn.text=st.name
    }
}