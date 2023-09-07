package com.projectIntro.componentlistapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Komponen(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
