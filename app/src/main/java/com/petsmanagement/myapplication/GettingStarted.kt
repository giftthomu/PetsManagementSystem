package com.petsmanagement.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_getting_started.*

class GettingStarted : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getting_started)

        btnClient.setOnClickListener{
            val i = Intent(this, SignUpActivity::class.java)
            startActivity(i)
        }

    }

}