package com.taufik.androidpemula

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.taufik.androidpemula.databinding.ActivityViewViewGroupBinding

class ViewViewGroupActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewViewGroupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewViewGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Google Pixel"

        setOnClickButton()
    }

    private fun setOnClickButton(){
        binding.apply {
            btnBuy.setOnClickListener {
                Toast.makeText(this@ViewViewGroupActivity, "Beli dong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}