package com.example.allsportsspikes

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showRandomNumber()
    }

    companion object {
        const val TOTAL_COUNT = "total count"
    }

    fun showRandomNumber(){
        val count = intent.getIntExtra(TOTAL_COUNT,0)
        val random = Random()
        var randomInt = 0
        if(count > 0 ){
            randomInt = random.nextInt(count + 1)
        }
        findViewById<TextView>(R.id.textview_random).text = Integer.toBinaryString(randomInt)
        findViewById<TextView>(R.id.textview_label).text = getString(R.string.random_heading,count)
    }

    fun comeBack(view: View){
        startActivity(Intent(this, MainActivity::class.java))
    }
}
