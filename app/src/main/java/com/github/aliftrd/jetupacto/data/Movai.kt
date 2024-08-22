package com.github.aliftrd.jetupacto.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movai(
    val title: String,
    val synopsis: String,
    val posterUrl: String,
) : Parcelable