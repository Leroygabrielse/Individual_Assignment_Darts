package com.leroygabrielse.dartsapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game (
    val GameName: String,
    val playerOneName: String,
    val playerTwoName: String,
    val numberOfLegsOrSets: Int

) : Parcelable