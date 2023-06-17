package com.flutter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var input_text:EditText
    lateinit var input_text1:EditText
    lateinit var btn_click_result:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input_text = findViewById(R.id.input_text)
        input_text1 = findViewById(R.id.input_text1)
        btn_click_result = findViewById(R.id.btn_click_result)

        fun checkEquals(string1: String, string2: String): List<String>
        {
            val commonChars = mutableListOf<String>()

            for (char in string1)
            {
                if (char.toString() in string2 && char.toString() !in commonChars)
                {
                    commonChars.add(char.toString())
                }
            }

            Log.d("listString", commonChars.joinToString { "," })
            return commonChars
        }

        fun showToast(strings: List<String>) {
            val message = strings.filter { it.isNotBlank() }.joinToString(", ")
            Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
        }

        btn_click_result.setOnClickListener {
            val commonStringResult = checkEquals(input_text.text.toString(), input_text1.text.toString())
            showToast(commonStringResult)
        }

    }
}