package com.example.finalapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapplication.R
import com.example.finalapplication.classes.Grade
import com.example.finalapplication.sqlitedb.DatabaseHelper

class CourseStdAdapter(val context: Context, val data:ArrayList<Grade>): RecyclerView.Adapter<CourseStdAdapter.AdapterHolder>() {
    class AdapterHolder(itView: View): RecyclerView.ViewHolder(itView){
        val cname= itView.findViewById<TextView>(R.id.corNameTv)
        val yearTv= itView.findViewById<TextView>(R.id.yearTv)
        val semesTv= itView.findViewById<TextView>(R.id.semesTv)
        val gradeTv= itView.findViewById<TextView>(R.id.gradeTv)
        val deletButton= itView.findViewById<Button>(R.id.deletButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder {
        val layout= LayoutInflater.from(context).inflate(R.layout.student_courses_item,parent,false)
        return AdapterHolder(layout)
    }

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        val db= DatabaseHelper(context,"helper",1)

//        val g= db.getGrade()
//        holder.cname.text= g[position].courseNm
//        holder.yearTv.text= g[position].yearOfSemester.toString()
//        holder.semesTv.text= g[position].semester
//        holder.gradeTv.text= g[position].gradeOfCourse.toString()

        val cstd= data[position]
        holder.cname.text=cstd.courseNm
        holder.yearTv.text=cstd.yearOfSemester.toString()
        holder.semesTv.text=cstd.semester
        holder.gradeTv.text=cstd.gradeOfCourse.toString()


        holder.deletButton.setOnClickListener {
            val dl=db.deleteGrade(position)
            if(dl){
                data.removeAt(position)
                notifyDataSetChanged()
            }
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

}