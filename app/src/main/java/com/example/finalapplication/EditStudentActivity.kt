package com.example.finalapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.finalapplication.sqlitedb.DatabaseHelper

class EditStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        var corSpn= findViewById<Spinner>(R.id.facspn)
        var stdNameEditEt= findViewById<EditText>(R.id.stdNameEditEt)
        var stdAddressEditEt= findViewById<EditText>(R.id.stdAddressEditEt)
        var stdDateBirthEditEt= findViewById<EditText>(R.id.stdDateBirthEditEt)
        var stdedtid= findViewById<TextView>(R.id.stdedtid)
        var editStdBtn= findViewById<Button>(R.id.editStdBtn)

        val db= DatabaseHelper(this,"helper",1)

        val fac=db.getFaculty()
        val spnamesfac= ArrayList<String>()
        for(i in 0 until fac.size){
            spnamesfac.add(fac[i].name)
        }

        val adaptersp= ArrayAdapter(this,android.R.layout.simple_spinner_item,spnamesfac)
        corSpn.adapter=adaptersp

        val i= intent
        //    val da=i.getParcelableExtra<Student>("stdinfo")
        if(i!= null){
            val id= i.getIntExtra("id",-1)
            val n=i.getStringExtra("name")
            val a=i.getStringExtra("address")
            val b=i.getStringExtra("birthDate")
            val f=i.getStringExtra("faculty")

            stdedtid.text= id.toString()
            stdNameEditEt.setText(n)
            stdAddressEditEt.setText(a)
            stdDateBirthEditEt.setText(b)

            editStdBtn.setOnClickListener {
                val u=db.editStudent(id,stdNameEditEt.text.toString(),stdAddressEditEt.text.toString(),
                    stdDateBirthEditEt.text.toString(),corSpn.selectedItem.toString())
                if(u)
                    Toast.makeText(this, "student update successfully", Toast.LENGTH_SHORT).show()
            }
        }



//        stdNameEditEt.setText(i.getStringExtra("name"))
//        stdAddressEditEt.setText(i.getStringExtra("address"))
//        stdDateBirthEditEt.setText(i.getStringExtra("birthDate"))







    }
}