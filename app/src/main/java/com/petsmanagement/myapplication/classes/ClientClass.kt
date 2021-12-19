package com.petsmanagement.myapplication.classes

import android.content.Intent
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.petsmanagement.myapplication.LoginActivity
import com.petsmanagement.myapplication.SignUpActivity
import com.petsmanagement.myapplication.models.ClientModel

class ClientClass {
    private val fstore = FirebaseFirestore.getInstance()

    fun registerClient(activity : SignUpActivity, ClientInfo : ClientModel){
        fstore.collection("Users").document(ClientInfo.id).set(ClientInfo, SetOptions.merge())
            .addOnCompleteListener {
                Toast.makeText(activity, "Registered successfully", Toast.LENGTH_SHORT).show()
                var i =Intent(activity, LoginActivity::class.java)
                activity.startActivity(i)
            }.addOnFailureListener { exception ->
                Toast.makeText(activity, "$exception", Toast.LENGTH_SHORT).show()
            }
    }
}