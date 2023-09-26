package com.example.finalapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.finalapplication.sqlitedb.DatabaseHelper

class AddCourseToStdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_course_to_std)

        val spinnercs= findViewById<Spinner>(R.id.spinnercs)
        val yearedt= findViewById<EditText>(R.id.yearedt)
        val semesteredt= findViewById<EditText>(R.id.semesteredt)
        val addcorbtn= findViewById<Button>(R.id.addcorbtn)

        val db= DatabaseHelper(this,"helper",1)

        val c= db.getCourse()

        val ids= intent.getIntExtra("id",-1)

        val namescor= ArrayList<String>()
        for(i in 0 until c.size )
            namescor.add(c[i].courseName)


        spinnercs.adapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,namescor)
        addcorbtn.setOnClickListener {
            if (addcorbtn.text.isEmpty())
                Toast.makeText(this, "please fill all fields", Toast.LENGTH_SHORT).show()
            else{
                val corseGrad= db.addGrade(ids,semesteredt.toString(),yearedt.text.toString().toInt(),
                    0.0,spinnercs.selectedItem.toString())

                    Toast.makeText(this, "Course Added Successfully", Toast.LENGTH_SHORT).show()
            }

        }


    }
}