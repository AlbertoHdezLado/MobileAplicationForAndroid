package com.example.activity2

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ActivityLeft : AppCompatActivity() {
    fun runDial(phoneNum: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNum")
        }
        startActivity(intent)

    }

    fun runBrowser(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_left)
        val buttonDialer = findViewById<Button>(R.id.runDialerButton)
        val buttonBrowser = findViewById<Button>(R.id.runBrowserButton)
        val num = findViewById<EditText>(R.id.phoneNum)
        val url = findViewById<EditText>(R.id.url)
        buttonDialer.setOnClickListener() {_ ->
            runDial(num.text.toString())
        }

        buttonBrowser.setOnClickListener {
            runBrowser(url.text.toString())
        }
    }
}