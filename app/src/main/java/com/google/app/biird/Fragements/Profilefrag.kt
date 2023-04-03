package com.google.app.biird.Fragements

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.google.app.biird.R

class Profilefrag : Fragment() {
    lateinit var img: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profilefrag, container, false)
        // Inflate the layout for this fragment
        img = view.findViewById(R.id.profileImg)
      val sp = context?.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
            val iuri = sp?.getString("uri", null)
            img.setImageURI(Uri.parse(iuri.toString()))


        img.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(intent, 102)
        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 102 && resultCode == Activity.RESULT_OK && data != null) {
            val imageUri = data.data  // Get the URI of the selected image
            // Use the image URI as needed
            img.setImageURI(imageUri)
            val sharedPreferences = context?.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
            val editor = sharedPreferences?.edit()
            editor?.putString("uri", imageUri.toString())
            editor?.apply()

// Retrieve the stored value
//            val myValue = sharedPreferences?.getString("uri", null)
//            if (myValue.isNullOrEmpty()){
//                Toast.makeText(context,"NOOOO",Toast.LENGTH_SHORT).show()
//            }else Toast.makeText(context,myValue.toString(),Toast.LENGTH_SHORT).show()
        }

    }

//    override fun onStart() {
//        super.onStart()
//        val sp=context?.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
//        val iuri=sp?.getString("uri", null)
//        img.setImageURI(Uri.parse(iuri))
//    }

//    override fun onResume() {
//        super.onResume()
//        val sp=context?.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
//        val iuri=sp?.getString("uri", null)
//        img.setImageURI(Uri.parse(iuri))
//    }
}