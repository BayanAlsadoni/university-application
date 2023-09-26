package com.example.finalapplication.sqlitedb

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.finalapplication.classes.Sign

class SignDataBase(context: Context, dbName:String, version:Int): SQLiteOpenHelper(context,dbName,null,version)  {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("create table signUp(id integer primary key autoIncrement,name text not null, email text,password text )")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("drop table if exists signUp")
        onCreate(db)
    }

    val db= this.writableDatabase

    fun insertSignUp(name: String, email: String, password: String):Boolean{
        val cv= ContentValues()
        cv.put("name", name)
        cv.put("email", email)
        cv.put("password", password)
        db.insert("signUp",null,cv)
        if(db.insert("signUp",null,cv)>0)
            return  true
        return  false
    }
    fun getSignIn():ArrayList<Sign>{
        var g= ArrayList<Sign>()
        val d= db.rawQuery("select email, password from signUp", null)
        d.moveToFirst()
        while (!d.isAfterLast){
            val s= Sign(d.getString(2), d.getString(3))
            g.add(s)
            d.moveToNext()
        }
        d.close()
        return g
    }

}

