package com.baktiyar11.bulletinboard.domain.models.category.medicalProducts

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MedicalProducts(
    @SerializedName("objectId") val idMedicalProducts: String,
    @SerializedName("category") var categoryMedicalProducts: String,
    @SerializedName("subCategory") var subCategoryMedicalProducts: String,
    @SerializedName("header") var headerMedicalProducts: String,
    @SerializedName("description") var descriptionMedicalProducts: String,
    @SerializedName("price") var priceMedicalProducts: String,
    @SerializedName("currency") var currencyMedicalProducts: String,
    @SerializedName("region") var regionMedicalProducts: String,
    @SerializedName("city") var cityMedicalProducts: String,
    @SerializedName("userId") var userIdMedicalProducts: String,
    @SerializedName("userName") var userNameMedicalProducts: String,
    @SerializedName("userPhone") var userPhoneMedicalProducts: String,
) : Serializable
