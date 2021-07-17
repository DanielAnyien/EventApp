package com.jetpack.eventapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import com.jetpack.eventapp.adapter.GuestAdapter
import com.jetpack.eventapp.databinding.ActivityGuestBinding
import com.jetpack.eventapp.model.Guest


class GuestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuestBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EVENT = "extra_event"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listView: GridView = findViewById(R.id.gridview)
        val adapter = GuestAdapter()
        listView.adapter = adapter

        val NamaUser = resources.getStringArray(R.array.nama)
        val Tgl = resources.getStringArray(R.array.tgl_lahir)
        val Avatar = resources.obtainTypedArray(R.array.avatar)

        val nama = intent.getStringExtra(EXTRA_NAME)
        val event = intent.getStringExtra(EXTRA_EVENT)

        val users = arrayListOf<Guest>()
        for (position in NamaUser.indices) {
            val user = Guest(
                Avatar.getResourceId(position, -1),
                NamaUser[position],
                Tgl[position]
            )
            users.add(user)
        }
        adapter.user = users

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(MainActivity.EXTRA_NAME, nama)
            intent.putExtra(MainActivity.EXTRA_GUEST, users[position].name)
            intent.putExtra(MainActivity.EXTRA_BD, users[position].birthdate)
            intent.putExtra(MainActivity.EXTRA_EVENT, event)
            startActivity(intent)
        }
    }
}