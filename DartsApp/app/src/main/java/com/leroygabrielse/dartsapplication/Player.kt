package com.leroygabrielse.dartsapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player (
    var name: String,
    var score: Int,
    var legs: Int,
    var sets: Int,
    var avg: Int,
    var thrown: Int
): Parcelable