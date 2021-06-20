package com.itzikpich.giniappssampleapp.models


import com.google.gson.annotations.SerializedName

data class NumbersResponse(
    @SerializedName("numbers")
    val numberItems: List<NumberItem>
) {
    data class NumberItem(
        @SerializedName("number")
        val number: Int // 40
    )
}