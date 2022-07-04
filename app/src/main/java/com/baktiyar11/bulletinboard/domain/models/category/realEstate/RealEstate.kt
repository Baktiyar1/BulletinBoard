package com.baktiyar11.bulletinboard.domain.models.category.realEstate

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RealEstate(
    @SerializedName("objectId") val idRealEstate: String,
    @SerializedName("category") var categoryRealEstate: String,
    @SerializedName("subCategory") var subCategoryRealEstate: String,
    @SerializedName("header") var headerRealEstate: String,
    @SerializedName("description") var descriptionRealEstate: String,
    @SerializedName("price") var priceRealEstate: String,
    @SerializedName("currency") var currencyRealEstate: String,
    @SerializedName("region") var regionRealEstate: String,
    @SerializedName("city") var cityRealEstate: String,
    @SerializedName("userId") var userIdRealEstate: String,
    @SerializedName("userName") var userNameRealEstate: String,
    @SerializedName("userPhone") var userPhoneRealEstate: String,
) : Serializable
