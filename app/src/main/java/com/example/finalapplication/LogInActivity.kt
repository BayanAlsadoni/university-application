package com.example.finalapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val emailEt= findViewById<EditText>(R.id.emailEt)
        val passwordEdt= findViewById<EditText>(R.id.passwordEdt)
        val logInBtn= findViewById<Button>(R.id.logInBtn)
        val goSignUp= findViewById<Button>(R.id.goSignUp)

        goSignUp.setOnClickListener{
            val i= Intent(applicationContext, SignUpActivity::class.java)
            startActivity(i)
        }

        logInBtn.setOnClickListener {
//            val db= SignDataBase(this)
//            val all=db.getSignIn()
//            /*
//            if (all.contains(emailEt.text.toString())&& all.contains(passwordEdt.text.toString())){
//                Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
//            }*/

            val i= Intent(this, MainActivity2::class.java)
            startActivity(i)
            finish()
        }

    }
}