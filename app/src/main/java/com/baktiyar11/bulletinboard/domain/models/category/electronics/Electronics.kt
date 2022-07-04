package com.baktiyar11.bulletinboard.domain.models.category.electronics

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Electronics(
    @SerializedName("objectId") val idElectronics: String,
    @SerializedName("category") var categoryElectronics: String,
    @SerializedName("subCategory") var subCategoryElectronics: String,
    @SerializedName("header") var headerElectronics: String,
    @SerializedName("description") var descriptionElectronics: String,
    @SerializedName("price") var priceElectronics: String,
    @SerializedName("currency") var currencyElectronics: String,
    @SerializedName("region") var regionElectronics: String,
    @SerializedName("city") var cityElectronics: String,
    @SerializedName("userId") var userIdElectronics: String,
    @SerializedName("userName") var userNameElectronics: String,
    @SerializedName("userPhone") var userPhoneElectronics: String,
) : Serializable
