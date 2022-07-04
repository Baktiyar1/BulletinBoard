package com.baktiyar11.bulletinboard.domain.models.category

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Category(
    @SerializedName("objectId") val idCategory: Int,
    @SerializedName("title") var categoryName: String,
    @SerializedName("description") var categoryDescription: String,
    @SerializedName("icon") var categoryIcon: Int,
) : Serializable