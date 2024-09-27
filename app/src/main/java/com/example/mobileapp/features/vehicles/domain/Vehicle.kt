package com.example.mobileapp.features.vehicles.domain

import android.net.Uri

data class Vehicle(
    val id: String,
    val brand: String,
    val model: String,
    val plate: String,
    val color: String,
    val imageUri: String
)