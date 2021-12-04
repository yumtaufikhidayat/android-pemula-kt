package com.taufik.androidpemula

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.taufik.androidpemula.databinding.ActivityMoveBinding

class MoveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}