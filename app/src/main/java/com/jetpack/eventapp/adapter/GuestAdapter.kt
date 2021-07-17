package com.jetpack.eventapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.jetpack.eventapp.R
import com.jetpack.eventapp.model.Guest

class GuestAdapter: BaseAdapter() {
    internal var user = arrayListOf<Guest>()

    override fun getCount(): Int = user.size

    override fun getItem(i: Int): Any = user[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        val itemView = view ?: LayoutInflater.from(viewGroup.context).inflate(R.layout.lv_item_card, viewGroup, false)
        val viewHolder = ViewHolder(itemView)

        viewHolder.bind(user[position])
        return itemView
    }

    private inner class ViewHolder constructor(itemView: View) {
        private val tv_name: TextView = itemView.findViewById(R.id.nm_guest)
        private val tv_date: TextView = itemView.findViewById(R.id.tgl_guest)
        private val iv_avatar: ImageView = itemView.findViewById(R.id.iv_avatar)

        fun bind(user: Guest){
            tv_name.text = user.name
            tv_date.text = user.birthdate
            iv_avatar.setImageResource(user.avatar)
        }


    }

}