package com.example.finalapplication.sqlitedb

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.finalapplication.classes.Course
import com.example.finalapplication.classes.Faculty
import com.example.finalapplication.classes.Grade
import com.example.finalapplication.classes.Student

class DatabaseHelper(context: Context, dbName:String, version:Int): SQLiteOpenHelper(context,dbName,null,version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("create table faculty( id integer primary key autoIncrement , name text , priceOfHour int)")
        db.execSQL("create table course(id text primary key , name text not null, hourNom int)")
        db.execSQL("create table student(id integer primary key , name text, address text, birthdate text, faculty text references faculty(name))")
//        db.execSQL("create table grade(id int primary key autoIncrement, studentId integer , semester text, yearOfSemester integer, gradeOfCourse real, courseName text )")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("drop table if exists faculty")
        db.execSQL("drop table if exists course")
        db.execSQL("drop table if exists student")
        db.execSQL("drop table if exists grade")
        onCreate(db)
    }

    var db= this.writableDatabase



    fun addStudent(id: Int, name:String, address:String, birthDate: String, faculty:String):Boolean{
        val cv= ContentValues()
        cv.put("id", id)
        cv.put("name",name)
        cv.put("address",address)
        cv.put("birthDate",birthDate)
        cv.put("faculty",faculty)

        val ins =db.insert("student",null, cv)

        return ins>0
    }

    fun  getStudent():ArrayList<Student>{
        val students= ArrayList<Student>()
        val std= db.rawQuery("select * from student",null)
        std.moveToFirst()
        while (!std.isAfterLast){
            val s= Student(std.getInt(0),std.getString(1),std.getString(2),
                std.getString(3),std.getString(4))
            students.add(s)
            std.moveToNext()
        }
        std.close()
        return students
    }

    fun  deleteStudent(id:Int):Boolean{
        return db.delete("student","id=$id",null)>0
    }

    fun editStudent(id:Int, name:String, address:String, birthdate:String, faculty:String):Boolean{
        val cv= ContentValues()
        cv.put("name",name)
        cv.put("address",address)
        cv.put("birthdate",birthdate)
        cv.put("faculty",faculty)
        return db.update("student",cv,"id= $id",null)>0
    }

    /*****************************************************************/
    fun addFaculty(name:String, priceOfHour:Int):Boolean{
        val cv= ContentValues()
        cv.put("name",name)
        cv.put("priceOfHour",priceOfHour)
        val ins= db.insert("faculty",null,cv)
        return ins>0
    }

    fun getFaculty():ArrayList<Faculty>{
        val faculties= ArrayList<Faculty>()
        val fac= db.rawQuery("select * from faculty",null)
        fac.moveToFirst()
        while (!fac.isAfterLast){
            val f= Faculty(fac.getString(1),fac.getInt(2))
            faculties.add(f)
            fac.moveToNext()
        }
        fac.close()
        return faculties
    }

    /********************************************************/
    fun addCourse(id:String , name:String, hourNom:Int):Boolean{
        val cv= ContentValues()
        cv.put("id",id)
        cv.put("name",name)
        cv.put("hourNom",hourNom)
        val ins= db.insert("course",null,cv)
        return  ins>0
    }

    fun getCourse():ArrayList<Course>{
        val courses= ArrayList<Course>()
        val cour= db.rawQuery("select * from course",null)
        cour.moveToFirst()
        while (!cour.isAfterLast){
            val c= Course(cour.getString(0),cour.getString(1),cour.getInt(2))
            courses.add(c)
            cour.moveToNext()
        }
        cour.close()
        return courses
    }

    /***************************************************************/
    fun addGrade(studentId :Int, semester :String, yearOfSemester: Int, gradeOfCourse:Double, coursNam:String):Boolean{
        val cv= ContentValues()
        cv.put("studentId",studentId)
        cv.put("semester",semester)
        cv.put("yearOfSemester",yearOfSemester)
        cv.put("gradeOfCourse",gradeOfCourse)
        cv.put("courseName",coursNam)
        val ins= db.insert("grade",null,cv)
        return ins>0
    }
    fun getGrade():ArrayList<Grade>{
        val grades=ArrayList<Grade>()
        val grd= db.rawQuery("select * from grade",null)
        grd.moveToFirst()
        while (!grd.isAfterLast){
            val g= Grade(grd.getInt(0),grd.getString(1),grd.getInt(2),grd.getDouble(3),grd.getString(4))
            grades.add(g)
            grd.moveToNext()
        }
        grd.close()
        return grades
    }
    fun deleteGrade(idG:Int):Boolean{
        if (db.delete("grade","id=$idG",null)>0)
            return true
        return false
    }


}







