package com.projectIntro.componentlistapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KomponenInfo(
    val voltage:String,
    val current:String,
    val type:String
): Parcelable {
    object Data{
        val default = KomponenInfo(
            voltage = "",
            current = "",
            type = ""
        )

        val komponenInfoList = listOf(
            KomponenInfo(
                voltage = "3.3 V",
                current = "8 mA",
                type = "74LS08"
            ),
            KomponenInfo(
                voltage = "5 V",
                current = "20 mA",
                type = "C503B"
            ),
            KomponenInfo(
                voltage = "15 V",
                current = "14 mA",
                type = "0105Y"
            ),
            KomponenInfo(
                voltage = "5 V",
                current = "20 mA",
                type = "D8CB32"
            ),
            KomponenInfo(
                voltage = "2 V",
                current = "100 mA",
                type = "IN4587"
            ),
            KomponenInfo(
                voltage = "7.5 V",
                current = "100 mA",
                type = "IR3205"
            ),
            KomponenInfo(
                voltage = "10 V",
                current = "15 mA",
                type = "LM741"
            ),
            KomponenInfo(
                voltage = "5 V",
                current = "10 mA",
                type = "74LS08"
            ),
            KomponenInfo(
                voltage = "100 V",
                current = "100 mA",
                type = "5QWE10"
            ),
            KomponenInfo(
                voltage = "400 V",
                current = "10 A",
                type = "TG42W2",
            )
        )
    }
}
