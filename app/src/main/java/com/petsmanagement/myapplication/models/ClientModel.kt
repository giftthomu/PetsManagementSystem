package com.petsmanagement.myapplication.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ClientModel (
    val id : String = "",
    val firstname: String = "",
    val lastname: String = "",
    val email: String = "",
    val password: String ="",
    var usertype : String = "Client" ) : Parcelable