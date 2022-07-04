package com.baktiyar11.bulletinboard.domain.models.category.sportAndHobbies

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SportAndHobbies (
    @SerializedName("objectId") val idSportAndHobbies: String,
    @SerializedName("category") var categorySportAndHobbies: String,
    @SerializedName("subCategory") var subCategorySportAndHobbies: String,
    @SerializedName("header") var headerSportAndHobbies: String,
    @SerializedName("description") var descriptionSportAndHobbies: String,
    @SerializedName("price") var priceSportAndHobbies: String,
    @SerializedName("currency") var currencySportAndHobbies: String,
    @SerializedName("region") var regionSportAndHobbies: String,
    @SerializedName("city") var citySportAndHobbies: String,
    @SerializedName("userId") var userIdSportAndHobbies: String,
    @SerializedName("userName") var userNameSportAndHobbies: String,
    @SerializedName("userPhone") var userPhoneSportAndHobbies: String,
) : Serializable