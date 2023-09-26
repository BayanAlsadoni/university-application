package com.example.finalapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn= findViewById<Button>(R.id.btn)

        btn.setOnClickListener {
            val i= Intent(this, LogInActivity::class.java)
            startActivity(i)
            finish()
        }

    }
}