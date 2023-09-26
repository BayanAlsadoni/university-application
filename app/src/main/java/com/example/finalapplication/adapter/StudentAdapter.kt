package com.example.finalapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapplication.AddCourseToStdActivity
import com.example.finalapplication.EditStudentActivity
import com.example.finalapplication.R
import com.example.finalapplication.StudentCoursesActivity
import com.example.finalapplication.classes.Student
import com.example.finalapplication.sqlitedb.DatabaseHelper

class StudentAdapter(val context:Context, val data:ArrayList<Student>):RecyclerView.Adapter<StudentAdapter.MyHolder>() {
    class MyHolder(viewItem:View):RecyclerView.ViewHolder(viewItem){
        var idtv = viewItem.findViewById<TextView>(R.id.idtv)
        var nametv = viewItem.findViewById<TextView>(R.id.nametv)
        var address = viewItem.findViewById<TextView>(R.id.addresstv)
        var birthDate = viewItem.findViewById<TextView>(R.id.birthdatetv)
        var faculty = viewItem.findViewById<TextView>(R.id.facultytv)
        var courseListBtn= viewItem.findViewById<Button>(R.id.courseList)
        var addCourseBtn= viewItem.findViewById<Button>(R.id.addCourse)
        var editStdtBtn= viewItem.findViewById<Button>(R.id.editStd)
        var deleteStdBtn= viewItem.findViewById<Button>(R.id.deleteStd)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v=LayoutInflater.from(context).inflate(R.layout.student_item,parent,false)
        return MyHolder(v)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val std= data[position]
        holder.idtv.text= std.id.toString()
        holder.nametv.text= std.name
        holder.address.text= std.address
        holder.birthDate.text= std.birthDate
        holder.faculty.text= std.faculty

        val db= DatabaseHelper(context,"helper",1)

        holder.courseListBtn.setOnClickListener {
            val i= Intent(context, StudentCoursesActivity::class.java)
            i.putExtra("std",data[position])
            context.startActivity(i)
        }
        holder.addCourseBtn.setOnClickListener {
            val i= Intent(context, AddCourseToStdActivity::class.java)
         //   val g= db.addGrade(std.id)
            i.putExtra("id",std.id)
            context.startActivity(i)
        }
        holder.editStdtBtn.setOnClickListener {
            val i= Intent(context, EditStudentActivity::class.java)
//            i.putExtra("stdinfo",data[position])
            //          i.putParcelableArrayListExtra("stdinfo",ArrayList(data))
            i.putExtra("id",data[position].id)
            i.putExtra("name",data[position].name)
            i.putExtra("address",data[position].address)
            i.putExtra("birthDate",data[position].birthDate)
            i.putExtra("faculty",data[position].faculty)
            context.startActivity(i)

        }
        holder.deleteStdBtn.setOnClickListener {
            db.deleteStudent(std.id)
            data.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}