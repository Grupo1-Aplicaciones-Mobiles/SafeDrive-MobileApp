package com.example.mobileapp.features.vehicles.data.remote

import com.example.mobileapp.features.vehicles.data.remote.dto.VehicleDto
import com.example.mobileapp.features.vehicles.domain.Vehicle
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface VehicleService {
    @GET("vehicles")
    suspend fun getVehicles(): Response<List<VehicleDto>>

    @POST("vehicles")
    suspend fun postVehicle(@Body vehicleDto: VehicleDto): Response<VehicleDto>

    @DELETE("vehicles/{id}")
    suspend fun deleteVehicle(@Path("id") id: String): Response<Unit>
}