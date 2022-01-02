package com.petsmanagement.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
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

        //registering
        btnSignUp.setOnClickListener{

            val firstname  = etFirstName.text.toString()
            val lastname  = etLastName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val confirm = etConfirmPassword.text.toString()

             if(TextUtils.isEmpty(firstname)){
                val snack = Snackbar.make(it,"firstname is required", Snackbar.LENGTH_LONG)
                snack.show()
                 etFirstName.setError("firstname is required")
                 etFirstName.requestFocus()
            }
             else if(TextUtils.isEmpty(lastname)){
                 val snack = Snackbar.make(it,"lastname is required", Snackbar.LENGTH_LONG)
                 snack.show()
                 etLastName.setError("lastname is required")
                 etLastName.requestFocus()
             }
            else if(TextUtils.isEmpty(email)){
                val snack = Snackbar.make(it,"Email is required", Snackbar.LENGTH_LONG)
                snack.show()
                 etEmail.setError("Email is required")
                 etEmail.requestFocus()
            }
            else if(TextUtils.isEmpty(password)){
                val snack = Snackbar.make(it,"Password is required", Snackbar.LENGTH_LONG)
                snack.show()
                 etPassword.setError("Password is Required")
                 etPassword.requestFocus()
            }
            else if(TextUtils.isEmpty(confirm)){
                val snack = Snackbar.make(it,"confirm password is required", Snackbar.LENGTH_LONG)
                snack.show()
                 etConfirmPassword.setError("Confirm password is required")
                 etConfirmPassword.requestFocus()
            }
            else if(!password.equals(confirm)) {
                val snack = Snackbar.make(it,"passwords does not match", Snackbar.LENGTH_LONG)
                snack.show()
            }

            else{
                registerClients()
                true
            }
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
                    etFirstName.text.toString().trim { it <= ' '},
                    etLastName.text.toString().trim { it <= ' '},
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