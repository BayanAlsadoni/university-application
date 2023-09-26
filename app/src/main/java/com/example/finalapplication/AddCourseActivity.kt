package com.example.finalapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.finalapplication.sqlitedb.DatabaseHelper

class AddCourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_course)

        val coursIdEt= findViewById<EditText>(R.id.coursIdEt)
        val cNameEt= findViewById<EditText>(R.id.cNameEt)
        val cHoursNomEt= findViewById<EditText>(R.id.cHoursNomEt)
        val addCousrBtn= findViewById<Button>(R.id.addCousrBtn)

        addCousrBtn.setOnClickListener {
            if (coursIdEt.text.isNotEmpty() && cNameEt.text.isNotEmpty()&& cHoursNomEt.text.isNotEmpty()){
                val db= DatabaseHelper(this,"helper",1)
                val dbCours=db.addCourse(coursIdEt.text.toString(),cNameEt.text.toString(),cHoursNomEt.text.toString().toInt())
                if(dbCours)
                    Toast.makeText(this, "Course Added Successfully", Toast.LENGTH_SHORT).show()
            }
        }


    }
}