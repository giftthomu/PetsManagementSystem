package com.petsmanagement.myapplication.classes

import android.content.Intent
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.petsmanagement.myapplication.LoginActivity
import com.petsmanagement.myapplication.RegisterVetsActivity
import com.petsmanagement.myapplication.models.VetModel

class VetClass {
    private val fstore = FirebaseFirestore.getInstance()

    fun registerVet(activity : RegisterVetsActivity, VetInfo : VetModel){
        fstore.collection("Users").document(VetInfo.id).set(VetInfo, SetOptions.merge())
            .addOnCompleteListener {
                Toast.makeText(activity, "Vet Registered successfully", Toast.LENGTH_SHORT).show()
                var i = Intent(activity, LoginActivity::class.java)
                activity.startActivity(i)
            }.addOnFailureListener { exception ->
                Toast.makeText(activity, "$exception", Toast.LENGTH_SHORT).show()
            }
    }



}