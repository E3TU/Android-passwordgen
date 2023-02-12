package com.example.passwordgen

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.RadioButton

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val actionBar = supportActionBar
        val switchtoDark = findViewById<RadioButton>(R.id.darkBtn)
        val switchtoLight = findViewById<RadioButton>(R.id.lightBtn)

        actionBar!!.title = "Theme";
        actionBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(actionbarColor)))
        actionBar.setDisplayHomeAsUpEnabled(true)

        switchtoLight.setOnClickListener{
            switchtoDark.isChecked = false
        }
        switchtoDark.setOnClickListener {
            switchtoLight.isChecked = false
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}