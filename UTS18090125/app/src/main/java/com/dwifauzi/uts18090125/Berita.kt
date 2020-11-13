package com.dwifauzi.uts18090125

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Berita (
    var name: String,
    var description: String,
    var photo: String
) : Parcelable