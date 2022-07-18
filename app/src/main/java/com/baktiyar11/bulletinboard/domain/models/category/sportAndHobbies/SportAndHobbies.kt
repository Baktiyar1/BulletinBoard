package com.baktiyar11.bulletinboard.domain.models.category.sportAndHobbies

import com.baktiyar11.bulletinboard.domain.models.Image
import com.baktiyar11.bulletinboard.domain.models.category.Abstract
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SportAndHobbies (
    @SerializedName("objectId") val id: String,
    @SerializedName("category") var category: String,
    @SerializedName("subCategory") var subcategory: String,
    @SerializedName("header") var header: String,
    @SerializedName("description") var description: String,
    @SerializedName("price") var price: String,
    @SerializedName("currency") var currency: String,
    @SerializedName("region") var region: String,
    @SerializedName("city") var city: String,
    @SerializedName("userId") var userId: String,
    @SerializedName("userName") var userName: String,
    @SerializedName("userPhone") var userPhone: String,
    @SerializedName("icon") var icon: Image
) : Serializable, Abstract()