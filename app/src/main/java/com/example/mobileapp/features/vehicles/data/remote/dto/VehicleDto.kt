package com.example.mobileapp.features.vehicles.data.remote.dto

import android.net.Uri
import com.example.mobileapp.features.vehicles.domain.Vehicle
import com.google.gson.annotations.SerializedName

data class VehicleDto(

    @SerializedName("id")
    val id: String? = null,
    @SerializedName("marca")
    val brand: String,
    @SerializedName("modelo")
    val model: String,
    @SerializedName("color")
    val color: String,
    @SerializedName("placa")
    val plate: String,
    @SerializedName("imageUri")
    val imageUri: String
)

fun VehicleDto.toVehicle(): Vehicle {
    return Vehicle(
        id = id?: "",
        brand = brand,
        model = model,
        color = color,
        plate = plate,
        imageUri = imageUri
    )
}
