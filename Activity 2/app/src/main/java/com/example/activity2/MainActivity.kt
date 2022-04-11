package com.example.activity2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bnNavView = findViewById<View>(R.id.bottom_nav) as BottomNavigationView

        bnNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bn_left -> startActivity(
                    Intent(this, ActivityLeft::class.java)
                )
                R.id.bn_center -> startActivity(
                    Intent(this, ActivityCenter::class.java))
                R.id.bn_right -> startActivity(
                    Intent(this, ActivityRight::class.java))
            }
            true
        }
    }
}