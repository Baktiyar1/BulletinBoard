package com.baktiyar11.bulletinboard.domain.models.category.work

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Work (
    @SerializedName("objectId") val idWork: String,
    @SerializedName("category") var categoryWork: String,
    @SerializedName("subCategory") var subCategoryWork: String,
    @SerializedName("header") var headerWork: String,
    @SerializedName("description") var descriptionWork: String,
    @SerializedName("price") var priceWork: String,
    @SerializedName("currency") var currencyWork: String,
    @SerializedName("region") var regionWork: String,
    @SerializedName("city") var cityWork: String,
    @SerializedName("userId") var userIdWork: String,
    @SerializedName("userName") var userNameWork: String,
    @SerializedName("userPhone") var userPhoneWork: String,
) : Serializable