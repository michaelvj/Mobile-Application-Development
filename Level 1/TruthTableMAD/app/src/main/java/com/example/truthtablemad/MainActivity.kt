package com.example.truthtablemad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        btnSubmit.setOnClickListener{ submit()}
    }

    private fun submit(){
        var correct = 0

        if(textFirst.text.toString().toUpperCase(Locale.ROOT) == "T"){
            correct++
        }

        if (textSecond.text.toString().toUpperCase(Locale.ROOT) == "F"){
            correct++
        }

        if(textThird.text.toString().toUpperCase(Locale.ROOT) == "F"){
            correct++
        }

        if(textFourth.text.toString().toUpperCase(Locale.ROOT) == "F"){
            correct++
        }

        Toast.makeText(this@MainActivity, getString(R.string.toast_message, correct), Toast.LENGTH_SHORT).show()
    }

}
