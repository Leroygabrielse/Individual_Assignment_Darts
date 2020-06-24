package com.leroygabrielse.dartsapplication

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "statsTable")
data class Stats (
    var legNumber: Int,
    var winner: String,
    var avgp1: String,
    var avgp2: String,
    var thrownp1: Int,
    var thrownp2: Int,
    @PrimaryKey var id: Long? = null
): Parcelable