package com.coding.buttonclickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "TextContents"

class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"onCreate: Called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()
        userInput.text.clear()

        button.setOnClickListener {
            Log.d(TAG,"onClick: Called")
            textView?.append(userInput.text)
            textView?.append("\n")
            userInput.text.clear()
        }
    }

    override fun onStart() {
        Log.d(TAG,"onStart: Called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG,"onRestoreInstanceState: Called")
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState?.getString(TEXT_CONTENTS, "")
    }

    override fun onResume() {
        Log.d(TAG,"onResume: Called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG,"onPause: Called")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG,"onSaveInstanceState: Called")
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_CONTENTS, textView?.text.toString())
    }

    override fun onStop() {
        Log.d(TAG,"onStop: Called")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG,"onRestart: Called")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy: Called")
        super.onDestroy()
    }
}