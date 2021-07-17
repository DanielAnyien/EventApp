package com.jetpack.eventapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.jetpack.eventapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = binding.tvNama

        binding.btnNext.setOnClickListener {
            var name1 = name.text.toString()
            val i = Intent(this@HomeActivity, MainActivity::class.java)
            i.putExtra(MainActivity.EXTRA_NAME, name1)
            startActivity(i)
        }
    }

}


