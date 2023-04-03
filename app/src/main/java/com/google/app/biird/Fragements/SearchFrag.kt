package com.google.app.biird.Fragements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.app.biird.Models.StoryModel
import com.google.app.biird.Models.User
import com.google.app.biird.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.security.Timestamp

class SearchFrag : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_search, container, false)
        // Inflate the layout for this fragment
        val txt=view?.findViewById<EditText>(R.id.Caption)
        val btn=view?.findViewById<Button>(R.id.button)
        val auth = Firebase.auth

        val cur=auth.currentUser?.uid.toString()
        btn?.setOnClickListener {
            val database = Firebase.database
            var users = StoryModel(R.drawable.story, txt?.text.toString())
            if(txt?.text.toString().isNullOrBlank()){
                Toast.makeText(context,"ERROR",Toast.LENGTH_SHORT).show()
            }else {
                database.reference.child("Stories").child(cur).child(System.currentTimeMillis().toString()).setValue(users)
                Toast.makeText(context, "Post added Successfully", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}