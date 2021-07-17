package com.jetpack.eventapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event (
    val avatar: Int,
    val name: String,
    val birthdate: String
): Parcelable