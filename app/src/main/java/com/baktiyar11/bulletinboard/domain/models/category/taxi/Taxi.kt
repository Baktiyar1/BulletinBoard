package com.baktiyar11.bulletinboard.domain.models.category.taxi

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Taxi(
    @SerializedName("objectId") val idTaxi: String,
    @SerializedName("category") var categoryTaxi: String,
    @SerializedName("subCategory") var subCategoryTaxi: String,
    @SerializedName("header") var headerTaxi: String,
    @SerializedName("description") var descriptionTaxi: String,
    @SerializedName("price") var priceTaxi: String,
    @SerializedName("currency") var currencyTaxi: String,
    @SerializedName("region") var regionTaxi: String,
    @SerializedName("city") var cityTaxi: String,
    @SerializedName("userId") var userIdTaxi: String,
    @SerializedName("userName") var userNameTaxi: String,
    @SerializedName("userPhone") var userPhoneTaxi: String,
) : Serializable
