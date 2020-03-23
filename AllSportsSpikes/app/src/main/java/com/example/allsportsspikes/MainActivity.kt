package com.example.allsportsspikes

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val welcome_text = TextView(this)
        welcome_text.textSize = 20f
        welcome_text.text = "Bienvenido a AllSports!"
        setContentView(R.layout.activity_main)
        main_layout.addView(welcome_text)

    }

    fun toastMe(view: View){
        val myToast = Toast.makeText(this,"Comprá papel!", Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun countMe(view: View){
        val showCountTextView = findViewById<TextView>(R.id.textView)
        val countString = showCountTextView.text.toString()
        var count: Int = 0
        var isStart: Boolean = countString.equals("Soy un número")
        if(!isStart){
            count = Integer.parseInt(countString)
            count++
        }
        showCountTextView.text = count.toString()
    }

    fun randomMe(view: View){
        val randomIntent = Intent(this, SecondActivity::class.java)
        val showCountTextView = findViewById<TextView>(R.id.textView)
        val countString = showCountTextView.text.toString()
        var count :Int = 0
        try {
            count = Integer.parseInt(countString)
        }catch (e:Exception){
            println("Todavía no había números baby!!!")
        }
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)
        startActivity(randomIntent)
    }

    fun login(view: View){
        val randomIntent = Intent(this, LoginActivity::class.java)
        startActivity(randomIntent)
    }
}
