package com.example.finalapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.finalapplication.sqlitedb.SignDataBase

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val goLogIn= findViewById<Button>(R.id.goLogIn)
        val regesterBtn= findViewById<Button>(R.id.regesterBtn)
        val nameEd= findViewById<EditText>(R.id.nameEd)
        val emailEd= findViewById<EditText>(R.id.emailEd)
        val passwordEt= findViewById<EditText>(R.id.passwordEt)


        regesterBtn.setOnClickListener {
            if(nameEd.text.isEmpty() || emailEd.text.isEmpty() || passwordEt.text.isEmpty())
                Toast.makeText(this, "please fill fields", Toast.LENGTH_SHORT).show()
            else{
                val db= SignDataBase(this,"sign",1)
                val ins= db.insertSignUp(nameEd.text.toString(),emailEd.text.toString(), passwordEt.text.toString())
                if(ins)
                    Toast.makeText(this, "insert successfully", Toast.LENGTH_SHORT).show()
                val i= Intent(this, MainActivity2::class.java)
                startActivity(i)
                finish()
            }


        }


        goLogIn.setOnClickListener {
            val i= Intent(this, LogInActivity::class.java)
            startActivity(i)
        }

    }
}