package com.petsmanagement.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class Splash_Screen : AppCompatActivity() {

    private val SPLASH_TIME: Long = 4000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed( {
            startActivity(Intent (this, LoginActivity::class.java))
            finish()
        },SPLASH_TIME)
    }
}