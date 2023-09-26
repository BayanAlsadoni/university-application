package com.example.finalapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isEmpty
import com.example.finalapplication.sqlitedb.DatabaseHelper

class AddStudentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_students)

        val idedt= findViewById<EditText>(R.id.idedt)
        val nameEdt= findViewById<EditText>(R.id.nameEdt)
        val addressEdt= findViewById<EditText>(R.id.addressEdt)
        val birhDateEdt= findViewById<EditText>(R.id.birhDateEdt)
        val facultySpinner= findViewById<Spinner>(R.id.facultySpinner)
        val addStdBtn= findViewById<Button>(R.id.addStdBtn)


        val database= DatabaseHelper(this,"helper",1)

        val data= database.getFaculty()

        val spnNames=ArrayList<String>()
        for ( i in 0 until  data.size){
            spnNames.add(data[i].name)
        }

        val arrAdaptSpn= ArrayAdapter(this,android.R.layout.simple_spinner_item,spnNames)
         arrAdaptSpn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        facultySpinner.adapter= arrAdaptSpn


        addStdBtn.setOnClickListener {
            if (idedt.text.isEmpty() || nameEdt.text.isEmpty()|| facultySpinner.isEmpty()){
                Toast.makeText(this, "please fill ID & Full Name& Spinner fields", Toast.LENGTH_SHORT).show()
            }else{
                val a= database.addStudent(idedt.text.toString().toInt(),nameEdt.text.toString(),addressEdt.text.toString(),
                    birhDateEdt.text.toString(),
                    facultySpinner.selectedItem.toString())
                if (a){
                    Toast.makeText(this, "Student Add Successfully", Toast.LENGTH_SHORT).show()
                }
            }
        }




    }
}