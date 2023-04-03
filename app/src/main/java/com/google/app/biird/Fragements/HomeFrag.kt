package com.google.app.biird.Fragements

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.app.biird.Adapters.PostAdapter
import com.google.app.biird.Adapters.StoryAdapter
import com.google.app.biird.Models.PostModel
import com.google.app.biird.Models.StoryModel
import com.google.app.biird.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HomeFrag : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        // Inflate the layout for this fragment
        val list:ArrayList<StoryModel>
        val post:ArrayList<PostModel>
        post=ArrayList()
        list= ArrayList()

        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Permission has already been granted, so you can access the gallery
        } else {
            // Permission has not been granted, so you need to request it
            requestPermissions(
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                100
            )
        }

        list.add(StoryModel(R.drawable.story,"helloworld"))
        list.add(StoryModel(R.drawable.story,"helloworld"))
        list.add(StoryModel(R.drawable.story,"helloworld"))
        list.add(StoryModel(R.drawable.story,"helloworld"))
        list.add(StoryModel(R.drawable.story,"helloworld"))
        list.add(StoryModel(R.drawable.story,"helloworld"))
        list.add(StoryModel(R.drawable.story,"helloworld"))
        list.add(StoryModel(R.drawable.story,"helloworld"))
        list.add(StoryModel(R.drawable.story,"helloworld"))
        list.add(StoryModel(R.drawable.story,"helloworld"))

        post.add(PostModel(R.drawable.post,"Helooo Worlffvshfgvsekt nwiigejfg isjg  ge gwopgk ojw  feogjop  "))
        post.add(PostModel(R.drawable.post,"Helooo Worlffvshfgvsekt nwiigejfg isjg  ge gwopgk ojw  feogjop  "))
        post.add(PostModel(R.drawable.post,"Helooo Worlffvshfgvsekt nwiigejfg isjg  ge gwopgk ojw  feogjop  "))
        post.add(PostModel(R.drawable.post,"Helooo Worlffvshfgvsekt nwiigejfg isjg  ge gwopgk ojw  feogjop  "))
        post.add(PostModel(R.drawable.post,"Helooo Worlffvshfgvsekt nwiigejfg isjg  ge gwopgk ojw  feogjop  "))
        post.add(PostModel(R.drawable.post,"Helooo Worlffvshfgvsekt nwiigejfg isjg  ge gwopgk ojw  feogjop  "))
        post.add(PostModel(R.drawable.post,"Helooo Worlffvshfgvsekt nwiigejfg isjg  ge gwopgk ojw  feogjop  "))
        post.add(PostModel(R.drawable.post,"Helooo Worlffvshfgvsekt nwiigejfg isjg  ge gwopgk ojw  feogjop  "))
        post.add(PostModel(R.drawable.post,"Helooo Worlffvshfgvsekt nwiigejfg isjg  ge gwopgk ojw  feogjop  "))
        post.add(PostModel(R.drawable.post,"Helooo Worlffvshfgvsekt nwiigejfg isjg  ge gwopgk ojw  feogjop  "))
        post.add(PostModel(R.drawable.post,"Helooo Worlffvshfgvsekt nwiigejfg isjg  ge gwopgk ojw  feogjop  "))
        post.add(PostModel(R.drawable.post,"Helooo Worlffvshfgvsekt nwiigejfg isjg  ge gwopgk ojw  feogjop  "))
        post.add(PostModel(R.drawable.story," HelloWorld "))




        val rec=view.findViewById<RecyclerView>(R.id.StoryRv)
        rec.layoutManager=LinearLayoutManager(view.context,LinearLayoutManager.HORIZONTAL,false)
        rec.adapter=StoryAdapter(view.context,list)

        val pos=view.findViewById<RecyclerView>(R.id.postRv)
        pos.adapter=PostAdapter(view.context,post)
        pos.layoutManager=LinearLayoutManager(view.context)
        return view
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 100) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission has been granted, so you can access the gallery
            } else {
                // Permission has not been granted, so inform the user
                Toast.makeText(
                    requireContext(),
                    "You need to grant permission to access the gallery",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }
}