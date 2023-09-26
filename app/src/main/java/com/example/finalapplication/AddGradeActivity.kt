package com.example.finalapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.finalapplication.sqlitedb.DatabaseHelper

class AddGradeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_grade)

        val stdIdEt = findViewById<EditText>(R.id.stdIdEt)
        val smsEt = findViewById<EditText>(R.id.smsEt)
        val smsYearEt = findViewById<EditText>(R.id.smsYearEt)
        val corGradeEt = findViewById<EditText>(R.id.corGradeEt)
        val coursSpenner= findViewById<Spinner>(R.id.courseSpinner)
        val addGradeBtn= findViewById<Button>(R.id.addGradeBtn)

        val db= DatabaseHelper(this,"helper",1)
        val cours= db.getCourse()
        val  nameCor= ArrayList<String>()
        for(i in 0 until cours.size)
            nameCor.add(cours[i].courseName)

        val courSpnAdapt= ArrayAdapter(this,android.R.layout.simple_spinner_item,nameCor)
        coursSpenner.adapter= courSpnAdapt

        addGradeBtn.setOnClickListener {
            if (stdIdEt.text.isNotEmpty()&& corGradeEt.text.isNotEmpty()){
                val addGrd= db.addGrade(stdIdEt.text.toString().toInt(), smsEt.text.toString(),smsYearEt.text.toString().toInt(),
                    corGradeEt.text.toString().toDouble(), coursSpenner.selectedItem.toString())
                if (addGrd!= null)
                    Toast.makeText(this, "Grade Added Successfully", Toast.LENGTH_SHORT).show()
            }

        }

    }
}