package com.petsmanagement.myapplication.classes

import android.app.Activity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.petsmanagement.myapplication.LoginActivity
import com.petsmanagement.myapplication.models.ClientModel
import com.petsmanagement.myapplication.models.VetModel

class UserClass {
    private val mFirestore = FirebaseFirestore.getInstance()
    private val mFirebaseAuth = FirebaseAuth.getInstance()
    fun getCurrentUser(): String {
        val currentUser = FirebaseAuth.getInstance().currentUser
        var currentUserID = ""

        if (currentUser != null) {
            currentUserID = currentUser.uid
        }
        return currentUserID
    }
    fun checkUserType(activity: Activity){
        mFirestore.collection("Users").document(getCurrentUser()).get()
            .addOnSuccessListener { document ->
                when{document!!.getString("usertype") == "Client" ->{
                    Log.i(activity.javaClass.simpleName, document.toString())
                    val client = document.toObject(ClientModel::class.java)!!
                    when(activity){
                        is LoginActivity -> {
                            activity.clientLoggedInSuccessfully(client)
                        }
                    }
                }
                document!!.getString("usertype") == "Vet" ->{
                Log.i(activity.javaClass.simpleName, document.toString())
                    var vet = document.toObject(VetModel::class.java)!!
                    when(activity){
                        is LoginActivity -> {
                            activity.vetLoggedInSuccessfully(vet)
                        }
                    }
                }
                else ->{
                    when (activity){
                        is LoginActivity -> {
                            activity.adminLoggedInSuccessfully()
                        }
                    }
                }
                }
            }

    }
}