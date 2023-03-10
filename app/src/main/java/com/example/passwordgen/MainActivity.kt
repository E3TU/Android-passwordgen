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
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.itemId
        val settings = R.id.settings_action;

        if (id == settings) {
//            Toast.makeText(this, "Item One Clicked", Toast.LENGTH_LONG).show();
            val settingsMenu = Intent(this, Settings::class.java)
            startActivity(settingsMenu)
            return true
        }

        return super.onOptionsItemSelected(item)

    }
}