package com.example.activity2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityCalc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
        val iii: Intent = getIntent()
        val bundle = iii.extras
        var val1:Int? = bundle?.getInt("val1",1)
        var val2:Int? = bundle?.getInt("val2",1)
        val buttonAdd = findViewById<Button>(R.id.button_add)
        buttonAdd.setOnClickListener { _ ->
            val res = val2?.let { val1?.plus(it) }
            iii.putExtra("result",res)
            setResult(RESULT_OK, iii)
            finish()
        }

        val buttonSub = findViewById<Button>(R.id.button_sub)
        buttonSub.setOnClickListener { _ ->
            val res = val2?.let { val1?.minus(it) }
            iii.putExtra("result",res)
            setResult(RESULT_OK, iii)
            finish()
        }

        val buttonMul = findViewById<Button>(R.id.button_mul)
        buttonMul.setOnClickListener { _ ->
            val res = val2?.let { val1?.times(it) }
            iii.putExtra("result",res)
            setResult(RESULT_OK, iii)
            finish()
        }
    }
}