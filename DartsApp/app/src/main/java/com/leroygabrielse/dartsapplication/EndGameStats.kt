package com.leroygabrielse.dartsapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate

@Parcelize
data class EndGameStats (
    val winner: String,
    val matchName: String,
    val contestants: String,
    val date: LocalDate
): Parcelable