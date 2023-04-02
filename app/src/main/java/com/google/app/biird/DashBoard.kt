package com.google.app.biird

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.app.biird.Fragements.HomeFrag
import com.google.app.biird.Fragements.Profilefrag
import com.google.app.biird.Fragements.SearchFrag
import com.google.firebase.auth.FirebaseAuth

class DashBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        supportActionBar!!.hide()
        val auth=FirebaseAuth.getInstance()
        findViewById<ImageView>(R.id.logout).setOnClickListener {
            auth.signOut()
            startActivity(Intent(this,Login::class.java))
            finish()
        }
        supportFragmentManager.beginTransaction().add(R.id.mainFrame,HomeFrag()).commit()
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnNavigationItemSelectedListener {item->
        when(item.itemId){
            R.id.home->{
                supportFragmentManager.beginTransaction().replace(R.id.mainFrame,HomeFrag()).commit()
                true
            }
            R.id.search->{
                supportFragmentManager.beginTransaction().replace(R.id.mainFrame,SearchFrag()).commit()
                true
            }
            R.id.profile->{
                supportFragmentManager.beginTransaction().replace(R.id.mainFrame,Profilefrag()).commit()
                true
            }
            else ->false
        }

        }
    }
}