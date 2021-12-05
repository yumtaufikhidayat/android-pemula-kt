package com.taufik.androidpemula

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.taufik.androidpemula.databinding.ActivityMoveWithDataBinding

class MoveWithDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoveWithDataBinding

    companion object {
        const val EXTRA_NAME = "com.taufik.androidpemula.EXTRA_NAME"
        const val EXTRA_AGE = "com.taufik.androidpemula.EXTRA_AGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveWithDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
    }

    private fun setData() {
        binding.apply {

            val name = intent.getStringExtra(EXTRA_NAME)
            val age = intent.getIntExtra(EXTRA_AGE, 0)

            val text = "My name is $name and my age is $age"
            tvDataReceived.text = text
        }
    }
}