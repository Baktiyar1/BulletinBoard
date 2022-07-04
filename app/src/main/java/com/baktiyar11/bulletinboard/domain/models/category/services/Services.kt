package com.baktiyar11.bulletinboard.domain.models.category.services

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Services(
    @SerializedName("objectId") val idServices: String,
    @SerializedName("category") var categoryServices: String,
    @SerializedName("subCategory") var subCategoryServices: String,
    @SerializedName("header") var headerServices: String,
    @SerializedName("description") var descriptionServices: String,
    @SerializedName("price") var priceServices: String,
    @SerializedName("currency") var currencyServices: String,
    @SerializedName("region") var regionServices: String,
    @SerializedName("city") var cityServices: String,
    @SerializedName("userId") var userIdServices: String,
    @SerializedName("userName") var userNameServices: String,
    @SerializedName("userPhone") var userPhoneServices: String,
) : Serializable
