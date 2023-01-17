package com.example.passwordgen

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.core.content.ContextCompat
import com.google.android.material.internal.ViewUtils.hideKeyboard
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Changing actionbar title and color
        val actionBar = supportActionBar;
        actionBar!!.title = "Password generator";
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#2E84BC")));

        val passwordLength = findViewById<SeekBar>(R.id.passwordLength);
        val generateButton = findViewById<Button>(R.id.generateBtn);
        val passwordOutput = findViewById<TextView>(R.id.passwordTxt);
        val copyButton = findViewById<Button>(R.id.copyBtn);

        fun generatepassWord(n: Int): String {
            val chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%&/()=?+-_.,*";
            val random = Random(System.nanoTime());
            val password = StringBuilder();

            for (i in 0 until n) {
                val randomindex = random.nextInt(chars.length);
                password.append(chars[randomindex]);
            }
            return password.toString();
        }
        fun printPassword() {
            val n = 20;
            //println(generatepassWord(n));
            passwordOutput.text = generatepassWord(n);
        }

        copyButton.setOnClickListener() {
            val copyPassword = passwordOutput.text;
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager;
            val clipData = ClipData.newPlainText("text", copyPassword);
            clipboardManager.setPrimaryClip(clipData);

            Toast.makeText(this, "Password copied", Toast.LENGTH_LONG).show()
        }

        generateButton.setOnClickListener() {
            printPassword();
            passwordLength.clearFocus();
        }
    }
}