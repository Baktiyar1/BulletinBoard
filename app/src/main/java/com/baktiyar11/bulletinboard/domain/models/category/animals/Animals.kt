package com.baktiyar11.bulletinboard.domain.models.category.animals

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Animals(
    @SerializedName("objectId") val idAnimals: String,
    @SerializedName("category") var categoryAnimals: String,
    @SerializedName("subCategory") var subCategoryAnimals: String,
    @SerializedName("header") var headerAnimals: String,
    @SerializedName("description") var descriptionAnimals: String,
    @SerializedName("price") var priceAnimals: String,
    @SerializedName("currency") var currencyAnimals: String,
    @SerializedName("region") var regionAnimals: String,
    @SerializedName("city") var cityAnimals: String,
    @SerializedName("userId") var userIdAnimals: String,
    @SerializedName("userName") var userNameAnimals: String,
    @SerializedName("userPhone") var userPhoneAnimals: String,
) : Serializable