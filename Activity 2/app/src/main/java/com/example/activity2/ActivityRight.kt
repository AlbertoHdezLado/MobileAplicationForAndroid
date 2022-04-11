package com.example.activity2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class ActivityRight : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_right)
        val buttonCalc = findViewById<Button>(R.id.bn_calc)
        val et1:EditText = findViewById<EditText>(R.id.edittext1)
        val et2:EditText = findViewById<EditText>(R.id.edittext2)
        buttonCalc.setOnClickListener { _ ->
            val val1:Int = et1.text.toString().toInt()
            val val2:Int = et2.text.toString().toInt()
            val bundle = Bundle()
            bundle.putInt("val1", val1)
            bundle.putInt("val2",val2)
            val intent = Intent(this, ActivityCalc::class.java)
            intent.putExtras(bundle)
            startForResult.launch(intent)
        }
    }

        val startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { result: ActivityResult ->
                if (result.resultCode == RESULT_OK)
                {
                    val intent = result.data
                    val i = intent?.getIntExtra("result",0)
                    if (i != null) {
                        val str = i.toString()
                        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
                    }
                }
            }

}