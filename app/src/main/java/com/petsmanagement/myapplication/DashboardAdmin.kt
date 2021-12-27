package com.petsmanagement.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dashboard_admin.*

class DashboardAdmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_admin)

   registerVetCard.setOnClickListener {
       val i = Intent(this, RegisterVetsActivity::class.java)
       startActivity(i)
   }
    }
}