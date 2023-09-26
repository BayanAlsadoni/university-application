package com.example.finalapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import com.example.finalapplication.adapter.ListAdapter
import com.example.finalapplication.classes.Universty

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        val data= ArrayList<Universty>()
        data.add(Universty("Show Students",R.drawable.students))
        data.add(Universty("Add Student",R.drawable.student))
        data.add(Universty("Add Faculty",R.drawable.faculty))
        data.add(Universty("Add Course",R.drawable.course))
        data.add(Universty("Add Grade",R.drawable.grade))

        val gv= findViewById<GridView>(R.id.gv)

        val listAdapter= ListAdapter(this, data)

        gv.adapter= listAdapter

        gv.setOnItemClickListener { adapterView, view, position, l ->
            if(position==0) {
                startActivity(Intent(this,StudentActivity::class.java))
            }
             else if(position==1){
                startActivity(Intent(this,AddStudentsActivity::class.java))
            }
        else if (position==2) {
                val addFac= Intent(this, FacultyActivity::class.java)
                startActivity(addFac)
            }
            else if (position==3){
                val addCourseAct = Intent(this,AddCourseActivity::class.java)
                startActivity(addCourseAct)
            }
            else if (position==4){
                val addGrade = Intent(this,AddGradeActivity::class.java)
                startActivity(addGrade)
            }
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()

        }



    }
}