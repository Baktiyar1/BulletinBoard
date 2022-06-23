package com.baktiyar11.bulletinboard.domain.models.category.transport

import androidx.room.PrimaryKey

data class TransportModel(
    @PrimaryKey var transportModelId: Int,
    var transportModelName: String,
    var transportModelIcon: Int
)
