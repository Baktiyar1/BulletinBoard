package com.baktiyar11.bulletinboard.domain.models.category.personalItems

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PersonalItems(
    @SerializedName("objectId") val idPersonalItems: String,
    @SerializedName("category") var categoryPersonalItems: String,
    @SerializedName("subCategory") var subCategoryPersonalItems: String,
    @SerializedName("header") var headerPersonalItems: String,
    @SerializedName("description") var descriptionPersonalItems: String,
    @SerializedName("price") var pricePersonalItems: String,
    @SerializedName("currency") var currencyPersonalItems: String,
    @SerializedName("region") var regionPersonalItems: String,
    @SerializedName("city") var cityPersonalItems: String,
    @SerializedName("userId") var userIdPersonalItems: String,
    @SerializedName("userName") var userNamePersonalItems: String,
    @SerializedName("userPhone") var userPhonePersonalItems: String,
) : Serializable
