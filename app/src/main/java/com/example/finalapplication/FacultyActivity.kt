package com.example.finalapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.finalapplication.sqlitedb.DatabaseHelper

class FacultyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty)

        val fNameEt = findViewById<EditText>(R.id.fNameEt)
        val fPriceHoureEt = findViewById<EditText>(R.id.fPriceHoureEt)
        val addFacultyBtn = findViewById<Button>(R.id.addFacultyBtn)

        addFacultyBtn.setOnClickListener {
            if (fNameEt.text.isEmpty() || fPriceHoureEt.text.isEmpty())
                Toast.makeText(this, "Please fell all field", Toast.LENGTH_SHORT).show()
            else{
                val db= DatabaseHelper(this,"helper",1)
                val addF =db.addFaculty(fNameEt.text.toString(),fPriceHoureEt.text.toString().toInt())
                if (addF)
                    Toast.makeText(this, "Faculty Added Successfully", Toast.LENGTH_SHORT).show()
            }
        }

    }
}