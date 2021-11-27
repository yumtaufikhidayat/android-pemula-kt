package com.taufik.androidpemula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // call function
        toDo()
    }

    private fun toDo() {
        // TODO 1 : do something
    }

    private fun todo2(num1: Int, num2: Int): Int {
        var result: Int
        result = num1 + num2
        result = num1 * num2
        return result
    }
}