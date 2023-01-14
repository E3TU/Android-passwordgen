package com.example.passwordgen

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Changing actionbar title and color
        val actionBar = supportActionBar;
        actionBar!!.title = "Password generator";
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#2E84BC")));

        val passwordSlider = findViewById<SeekBar>(R.id.passwordLength);

    }
}