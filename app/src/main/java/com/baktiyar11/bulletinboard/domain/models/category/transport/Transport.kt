package com.baktiyar11.bulletinboard.domain.models.category.transport

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

@Entity(tableName = "transport_database")
data class Transport(
    @PrimaryKey(autoGenerate = true) val idTransportRoom: Int = Random().nextInt(1000),
    @SerializedName("objectsId") var transportId: String,
    @SerializedName("categoryId") var transportCategoryId: String,
    @SerializedName("title") var transportTitle: String,
    @SerializedName("category") var transportCategory: String,
    @SerializedName("subCategory") var transportSubCategory: String,
    @SerializedName("model") var transportModel: String,
    @SerializedName("brand") var transportBrand: String,
    @SerializedName("year") var transportYear: String,
    @SerializedName("bodyType") var transportBodyType: String,
    @SerializedName("fuelType") var transportFuelType: String,
    @SerializedName("color") var transportColor: String,
    @SerializedName("RRCType") var transportRRCType: String,
    @SerializedName("steeringWheel") var transportSteeringWheel: String,
    @SerializedName("condition") var transportCondition: String,
    @SerializedName("engineCapacity") var transportEngineCapacity: String,
    @SerializedName("header") var transportHeader: String,
    @SerializedName("description") var transportDescription: String,
    @SerializedName("price") var transportPrice: String,
    @SerializedName("currency") var transportCurrency: String,
    @SerializedName("region") var transportRegion: String,
    @SerializedName("city") var transportCity: String,
    @SerializedName("userId") var transportUserID: String,
    @SerializedName("userName") var transportUserName: String,
) : Serializable