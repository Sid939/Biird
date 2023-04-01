package com.google.app.biird

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        val user=findViewById<EditText>(R.id.etUserName)
        val email=findViewById<EditText>(R.id.etEmail)
        val pass=findViewById<EditText>(R.id.etPass)
        findViewById<TextView>(R.id.etlogin).setOnClickListener {
            startActivity(Intent(this,Login::class.java))
            finish()
        }
       findViewById<Button>(R.id.btnSignup).setOnClickListener {
           if(user.text.toString().isNullOrBlank() ||email.text.toString().isNullOrBlank()||pass.text.toString().isNullOrBlank() ){
               Toast.makeText(this,"All fields are Required",Toast.LENGTH_SHORT).show()
           }else{

           }
       }
    }
}