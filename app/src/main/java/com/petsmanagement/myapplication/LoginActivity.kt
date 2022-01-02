package com.petsmanagement.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.petsmanagement.myapplication.classes.UserClass
import com.petsmanagement.myapplication.models.ClientModel
import com.petsmanagement.myapplication.models.VetModel
import kotlinx.android.synthetic.main.activity_sign_up.*

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnSignUp.setOnClickListener {
            val i = Intent(this, SignUpActivity::class.java)
            startActivity(i)
        }
        btnLogin.setOnClickListener {
            val i = Intent(this, DashboardAdmin::class.java)
            startActivity(i)
        }
        btnLogin.setOnClickListener {
            loginUser()
        }
    }
    private fun loginUser(){
        val email : String = etEmail.text.toString().trim() { it <= ' '}
        val password : String = etPassword.text.toString().trim() { it <= ' '}

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful){
                UserClass().checkUserType(this)
            }
            else{
                Toast.makeText(this, "${task.exception!!}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun clientLoggedInSuccessfully(client: ClientModel) {
        var i = Intent(this@LoginActivity, ClientHomePage::class.java)
        startActivity(i)
    }

    fun vetLoggedInSuccessfully(vet: VetModel) {
        var i = Intent(this@LoginActivity, VetHomePage::class.java)
        startActivity(i)    }

    fun adminLoggedInSuccessfully() {
        var i = Intent(this@LoginActivity, DashboardAdmin::class.java)
        startActivity(i)    }
}