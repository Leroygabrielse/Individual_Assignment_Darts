package com.leroygabrielse.dartsapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Stats (
    var legNumber: Int,
    var winner: String,
    var avgp1: Int,
    var avgp2: Int,
    var thrownp1: Int,
    var thrownp2: Int,
    var oneEigthies: Int,
    var oneFortys: Int
): Parcelable