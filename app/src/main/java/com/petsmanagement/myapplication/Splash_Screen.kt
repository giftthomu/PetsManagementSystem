package com.petsmanagement.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.os.HandlerCompat.postDelayed

class Splash_Screen : AppCompatActivity() {

    private val SPLASH_TIME: Long = 9000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed( {
            startActivity(Intent (this, SignUpActivity::class.java))
            finish()
        },SPLASH_TIME)
    }
}