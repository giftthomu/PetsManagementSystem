package com.petsmanagement.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.petsmanagement.myapplication.classes.ClientClass
import com.petsmanagement.myapplication.models.ClientModel
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    private val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnLogin.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
        btnSignUp.setOnClickListener{
            registerClients()
        }

    }
    fun registerClients (){
        val email:String = etEmail.text.toString().trim{ it<=' '}
        val password:String = etPassword.text.toString().trim{ it<=' '}

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if (task.isSuccessful){
                var firebaseUser : FirebaseUser = task.result!!.user!!
                var Client = ClientModel(
                    firebaseUser.uid,
                    etName.text.toString().trim { it <= ' '},
                    etEmail.text.toString().trim { it <= ' '},
                    etPassword.text.toString().trim { it <= ' '}
                    )
                ClientClass().registerClient(this, Client)
            }else{
                Toast.makeText(this, "${task.exception!!.message!!.toString()}", Toast.LENGTH_SHORT).show()
            }

        }
    }
}