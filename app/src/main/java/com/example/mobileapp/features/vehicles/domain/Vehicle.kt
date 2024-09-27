package com.example.mobileapp.features.vehicles.domain

data class Vehicle(
    val id: String,
    val brand: String,
    val model: String,
    val plate: String,
    val color: String,
    val imageUrl: String
)