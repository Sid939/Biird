package com.google.app.biird

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()
        findViewById<TextView>(R.id.etsignup).setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}