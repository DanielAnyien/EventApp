package com.jetpack.eventapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import com.jetpack.eventapp.adapter.EventAdapter
import com.jetpack.eventapp.databinding.ActivityEventBinding
import com.jetpack.eventapp.model.Event

class EventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_GUEST = "extra_guest"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listView: ListView = findViewById(R.id.listview)
        val adapter = EventAdapter()
        listView.adapter = adapter

        val NamaUser = resources.getStringArray(R.array.nama1)
        val Tgl = resources.getStringArray(R.array.tgl_lahir1)
        val Avatar = resources.obtainTypedArray(R.array.avatar1)

        val nama = intent.getStringExtra(EXTRA_NAME)
        val guest = intent.getStringExtra(EXTRA_GUEST)

        val users = arrayListOf<Event>()
        for (position in NamaUser.indices) {
            val user = Event(
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
            intent.putExtra(MainActivity.EXTRA_EVENT, users[position].name)
            intent.putExtra(MainActivity.EXTRA_GUEST, guest)
            startActivity(intent)
        }
    }
}