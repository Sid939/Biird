package com.google.app.biird.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.app.biird.Models.PostModel
import com.google.app.biird.Models.StoryModel
import com.google.app.biird.R

class PostAdapter(val context : Context, val list : ArrayList<PostModel>):RecyclerView.Adapter<PostAdapter.StroyHolder>()  {
    class StroyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val img=itemView.findViewById<ImageView>(R.id.postImg)
        val bio=itemView.findViewById<TextView>(R.id.about)
        val like=itemView.findViewById<ImageView>(R.id.like)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.StroyHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.sample_post,parent,false)
        return PostAdapter.StroyHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PostAdapter.StroyHolder, position: Int) {
        val its:PostModel=list.get(position)
        holder.img.setImageResource(its.img)
        holder.bio.text=its.caption
        var i=false
        holder.like.setOnClickListener {
            i=!i
            if(i==true) holder.like.setImageResource(R.drawable.redlike)
            else holder.like.setImageResource(R.drawable.blacnklike)
        }
    }
}