package com.baktiyar11.bulletinboard.domain.models.category.transport

import com.baktiyar11.bulletinboard.domain.models.Image
import com.baktiyar11.bulletinboard.domain.models.category.Abstract
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Transport(
    @SerializedName("objectId") var id: String,
    @SerializedName("category") var category: String,
    @SerializedName("subCategory") var subcategory: String,
    @SerializedName("model") var model: String,
    @SerializedName("brand") var brand: String,
    @SerializedName("year") var year: String,
    @SerializedName("bodyType") var bodyType: String,
    @SerializedName("driverUnit") var driverUnit: String,
    @SerializedName("fuelType") var fuelType: String,
    @SerializedName("color") var color: String,
    @SerializedName("RRCType") var rrcType: String,
    @SerializedName("steeringWheel") var steeringWheel: String,
    @SerializedName("condition") var condition: String,
    @SerializedName("engineCapacity") var engineCapacity: String,
    @SerializedName("header") var header: String,
    @SerializedName("description") var description: String,
    @SerializedName("price") var price: String,
    @SerializedName("currency") var currency: String,
    @SerializedName("region") var region: String,
    @SerializedName("city") var city: String,
    @SerializedName("userId") var userID: String,
    @SerializedName("userName") var userName: String,
    @SerializedName("userPhone") var userPhone: String,
    @SerializedName("icon") var icon: Image
) : Serializable, Abstract()