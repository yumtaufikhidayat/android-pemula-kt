package com.taufik.androidpemula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // call function
        toDo()
        todo2(1, 2)
    }

    private fun toDo() {
        // TODO 1 : do something
    }

    private fun todo2(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}