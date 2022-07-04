package com.baktiyar11.bulletinboard.domain.models.category.childrenWord

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ChildrenWord(
    @SerializedName("objectId") val idChildrenWord: String,
    @SerializedName("category") var categoryChildrenWord: String,
    @SerializedName("subCategory") var subCategoryChildrenWord: String,
    @SerializedName("header") var headerChildrenWord: String,
    @SerializedName("description") var descriptionChildrenWord: String,
    @SerializedName("price") var priceChildrenWord: String,
    @SerializedName("currency") var currencyChildrenWord: String,
    @SerializedName("region") var regionChildrenWord: String,
    @SerializedName("city") var cityChildrenWord: String,
    @SerializedName("userId") var userIdChildrenWord: String,
    @SerializedName("userName") var userNameChildrenWord: String,
    @SerializedName("userPhone") var userPhoneChildrenWord: String,
) : Serializable
