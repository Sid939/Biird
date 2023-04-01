package com.google.app.biird

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.app.biird.Models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        auth = Firebase.auth
        val database = Firebase.database
        val euser = findViewById<EditText>(R.id.etUserName)
        val email = findViewById<EditText>(R.id.etEmail)
        val pass = findViewById<EditText>(R.id.etPass)
        findViewById<TextView>(R.id.etlogin).setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
        }
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please wait...")
        progressDialog.setTitle("Please wait")
        progressDialog.setCancelable(false)
        findViewById<Button>(R.id.btnSignup).setOnClickListener {
            progressDialog.show()
            if (euser.text.toString().isNullOrBlank() || email.text.toString()
                    .isNullOrBlank() || pass.text.toString().isNullOrBlank()
            ) {
                Toast.makeText(this, "All fields are Required", Toast.LENGTH_SHORT).show()
            } else {
                auth.createUserWithEmailAndPassword(email.text.toString(), pass.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            var users:User=User(euser.text.toString(),email.text.toString(),pass.text.toString())
                            val id:String=task.result.user?.uid.toString()
                            database.reference.child("Users").child(id).setValue(users)
                            Toast.makeText(this,"User Created",Toast.LENGTH_SHORT).show()
                            progressDialog.dismiss()
                            startActivity(Intent(this, DashBoard::class.java))
                            finish()
                        } else {
                            // If sign in fails, display a message to the user.
                            progressDialog.dismiss()
                            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if(auth.currentUser!=null){
            startActivity(Intent(this, DashBoard::class.java))
        }
    }
}