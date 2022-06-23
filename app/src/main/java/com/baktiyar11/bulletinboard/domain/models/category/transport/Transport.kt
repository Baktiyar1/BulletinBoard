package com.baktiyar11.bulletinboard.domain.models.category.transport

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "transport_database")
data class Transport(
    @PrimaryKey(autoGenerate = true) val idTransportRoom: Int = Random().nextInt(1000),
    var transportId: String,
    var transportCategoryId: String,
    var transportTitle: String,
    var transportCategory: String,
    var transportSubCategory: String,
    var transportModel: String,
    var transportBrand: String,
    var transportYear: String,
    var transportBodyType: String,
    var transportFuelType: String,
    var transportColor: String,
    var transportRRCType: String,
    var transportSteeringWheel: String,
    var transportCondition: String,
    var transportEngineCapacity: String,
    var transportHeader: String,
    var transportDescription: String,
    var transportPrice: String,
    var transportCurrency: String,
    var transportRegion: String,
    var transportCity: String,
    var transportUserID: String,
    var transportUserName: String,
) : Serializable