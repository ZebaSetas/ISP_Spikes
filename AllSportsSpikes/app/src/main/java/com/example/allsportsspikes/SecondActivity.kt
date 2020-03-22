package com.example.allsportsspikes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)
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

    }
}
