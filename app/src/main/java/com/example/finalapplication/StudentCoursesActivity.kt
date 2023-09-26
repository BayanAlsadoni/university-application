package com.example.finalapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapplication.adapter.CourseStdAdapter
import com.example.finalapplication.sqlitedb.DatabaseHelper

class StudentCoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_courses)

        val dtbs= DatabaseHelper(this,"helper",1)
        val gradeData= dtbs.getGrade()


        val cstdAdapt= CourseStdAdapter(this, gradeData)


        val stdCRV= findViewById<RecyclerView>(R.id.stdCRV)
        val stdid= findViewById<TextView>(R.id.stdid)



        stdCRV.layoutManager= LinearLayoutManager(this)

        stdCRV.adapter= cstdAdapt


    }
}