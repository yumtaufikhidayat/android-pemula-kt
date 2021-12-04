package com.taufik.androidpemula

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.taufik.androidpemula.databinding.ActivityIntentBinding

class IntentActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClickButton()
    }

    private fun onClickButton() {
        binding.apply {
            btnMoveToActivity.setOnClickListener(this@IntentActivity)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnMoveToActivity -> {
                startActivity(Intent(this, MoveActivity::class.java))
            }
        }
    }
}