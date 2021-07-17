package com.jetpack.eventapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.jetpack.eventapp.adapter.EventAdapter
import com.jetpack.eventapp.databinding.ActivityMainBinding
import com.jetpack.eventapp.model.Event
import com.jetpack.eventapp.model.Guest

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EVENT = "extra_event"
        const val EXTRA_GUEST = "extra_guest"
        const val EXTRA_BD = "extra_bd"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nama = intent.getStringExtra(EXTRA_NAME)
        val event = intent.getStringExtra(EXTRA_EVENT)
        val nguest = intent.getStringExtra(EXTRA_GUEST)
        val tguest = intent.getStringExtra(EXTRA_BD)

        binding.apply {

            binding.btnEvent.setOnClickListener {
                val i = Intent (this@MainActivity, EventActivity::class.java)
                i.putExtra(EventActivity.EXTRA_NAME, nama)
                i.putExtra(EventActivity.EXTRA_GUEST, nguest)
                startActivity(i)
            }

            binding.btnGuest.setOnClickListener {
                val j = Intent (this@MainActivity, GuestActivity::class.java)
                j.putExtra(GuestActivity.EXTRA_NAME, nama)
                j.putExtra(GuestActivity.EXTRA_EVENT, event)
                startActivity(j)
            }

            tvNama1.text = "Nama : $nama"

            if (event == null){
                btnEvent.text = "Pilih Event"
            } else {
                btnEvent.text = "${event} Birthday"
            }

            if (nguest == null){
                btnGuest.text = "Pilih Guest"
            } else {
                btnGuest.text = nguest
            }

            if (tguest != null) {
                if (time(tguest)%3 == 0 && time(tguest)%2 == 0) {
                    Toast.makeText(this@MainActivity, "IOS", Toast.LENGTH_SHORT).show()
                } else if (time(tguest)%3 == 0) {
                    Toast.makeText(this@MainActivity, "Android", Toast.LENGTH_SHORT).show()
                } else if (time(tguest)%2 == 0) {
                    Toast.makeText(this@MainActivity, "Blackberry", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun time(tguest: String): Int {
        val g = tguest.substring(8)
        return g.toInt()
    }
}

