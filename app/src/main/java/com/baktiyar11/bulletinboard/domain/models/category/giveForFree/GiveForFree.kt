package com.baktiyar11.bulletinboard.domain.models.category.giveForFree

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GiveForFree(
    @SerializedName("objectId") val idGiveForFree: String,
    @SerializedName("category") var categoryGiveForFree: String,
    @SerializedName("header") var headerGiveForFree: String,
    @SerializedName("description") var descriptionGiveForFree: String,
    @SerializedName("price") var priceGiveForFree: String,
    @SerializedName("currency") var currencyGiveForFree: String,
    @SerializedName("region") var regionGiveForFree: String,
    @SerializedName("city") var cityGiveForFree: String,
    @SerializedName("userId") var userIdGiveForFree: String,
    @SerializedName("userName") var userNameGiveForFree: String,
    @SerializedName("userPhone") var userPhoneGiveForFree: String,
) : Serializable
