package com.petsmanagement.myapplication.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class VetModel (
    val id : String = "",
    val FirstName: String = "",
    val LastName: String = "",
    val VetType: String = "",
    val Email: String = "",
    val password: String ="",
    var usertype : String = "Vet") : Parcelable