package com.example.passwordgen

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlin.random.Random
const val actionbarTitle = "Password generator"
const val actionbarColor = "#2E84BC"


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Changing actionbar title and color
        val actionBar = supportActionBar
        actionBar!!.title = actionbarTitle
        actionBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(actionbarColor)))

        val passwordLength = findViewById<SeekBar>(R.id.passwordLength)
        val generateButton = findViewById<Button>(R.id.generateBtn)
        val passwordOutput = findViewById<TextView>(R.id.passwordTxt)
        val copyButton = findViewById<Button>(R.id.copyBtn)
        val lengthTw = findViewById<TextView>(R.id.lengthTw)

        fun generatepassWord(n: Int): String {
            val chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%&/()=?+-_.,*"
            val random = Random(System.nanoTime())
            val password = StringBuilder()

            for (i in 0 until n) {
                val randomindex = random.nextInt(chars.length)
                password.append(chars[randomindex])
            }
            return password.toString()
        }
        fun printPassword() {
            val n = passwordLength.progress
            //println(generatepassWord(n));
            passwordOutput.text = generatepassWord(n)
        }

        copyButton.setOnClickListener {
            val copyPassword = passwordOutput.text
            if (passwordOutput.text == "Click generate") {
                Toast.makeText(this, "Generate password first", Toast.LENGTH_LONG).show()
            }
            else {
                val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clipData = ClipData.newPlainText("text", copyPassword)

                clipboardManager.setPrimaryClip(clipData)

                Toast.makeText(this, "Password copied", Toast.LENGTH_LONG).show()
            }

        }

        generateButton.setOnClickListener {
            printPassword()
            passwordLength.clearFocus()
        }

        passwordLength?.setOnSeekBarChangeListener(object :
        SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                // write custom code for progress is changed
                lengthTw.text = "Password length: " + progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // write custom code for progress is stopped
            }
        })
    }
}