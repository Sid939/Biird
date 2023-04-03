package com.google.app.biird.Fragements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.app.biird.Adapters.PostAdapter
import com.google.app.biird.Adapters.StoryAdapter
import com.google.app.biird.Models.PostModel
import com.google.app.biird.Models.StoryModel
import com.google.app.biird.R
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

        val rec=view.findViewById<RecyclerView>(R.id.StoryRv)
        rec.layoutManager=LinearLayoutManager(view.context,LinearLayoutManager.HORIZONTAL,false)
        rec.adapter=StoryAdapter(view.context,list)

        val pos=view.findViewById<RecyclerView>(R.id.postRv)
        pos.adapter=PostAdapter(view.context,post)
        pos.layoutManager=LinearLayoutManager(view.context)
        return view
    }
}