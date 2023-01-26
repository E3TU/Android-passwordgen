package com.example.passwordgen

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val actionBar = supportActionBar

        actionBar!!.title = actionbarTitle
        actionBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(actionbarColor)))


        actionBar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}