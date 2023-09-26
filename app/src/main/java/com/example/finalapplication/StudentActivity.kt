package com.example.finalapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapplication.adapter.StudentAdapter
import com.example.finalapplication.sqlitedb.DatabaseHelper

class StudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        val p= DatabaseHelper(this,"helper",1)
        val data= p.getStudent()

        val adapt= StudentAdapter(this,data)


        val rcv= findViewById<RecyclerView>(R.id.rc)

        rcv.layoutManager= LinearLayoutManager(applicationContext)

        rcv.adapter= adapt



    }
}