package com.petsmanagement.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.petsmanagement.myapplication.classes.VetClass
import com.petsmanagement.myapplication.models.VetModel
import kotlinx.android.synthetic.main.activity_register_vets.*

class RegisterVetsActivity : AppCompatActivity() {

    private val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_vets)

        //registering
        btnRegisterVet.setOnClickListener {
            registerVet()
        }
    }

    fun registerVet() {
        val email: String = Email.text.toString().trim { it <= ' ' }
        val password: String = Password.text.toString().trim { it <= ' ' }

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {

                var firebaseUser: FirebaseUser = task.result!!.user!!
                var Vet = VetModel(
                    firebaseUser.uid,
                    FirstName.text.toString().trim { it <= ' ' },
                    LastName.text.toString().trim { it <= ' ' },
                    VetType.text.toString().trim { it <= ' ' },
                    Email.text.toString().trim { it <= ' ' },
                    Password.text.toString().trim { it <= ' ' }
                )
                VetClass().registerVet(this, Vet)

            } else {

                Toast.makeText(this, "${task.exception!!.message!!.toString()}", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

    }