package com.example.passwordgen

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import com.google.android.material.internal.ViewUtils.hideKeyboard

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Changing actionbar title and color
        val actionBar = supportActionBar;
        actionBar!!.title = "Password generator";
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#2E84BC")));

        val passwordLength = findViewById<EditText>(R.id.passwordLength);
        val generateButton = findViewById<Button>(R.id.generateBtn);

        generateButton.setOnClickListener() {
            passwordLength.clearFocus();
        }
    }
}