package com.example.mobileapp.features.vehicles.data.repository

import com.example.mobileapp.features.vehicles.common.Resource
import com.example.mobileapp.features.vehicles.data.remote.VehicleService
import com.example.mobileapp.features.vehicles.data.remote.dto.VehicleDto
import com.example.mobileapp.features.vehicles.data.remote.dto.toVehicle
import com.example.mobileapp.features.vehicles.domain.Vehicle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VehicleRepository(private val service: VehicleService) {
    suspend fun getVehicles(): Resource<List<Vehicle>> = withContext(Dispatchers.IO) {
        try {
            val response = service.getVehicles()
            if (response.isSuccessful) {
                response.body()?.let {vehiclesDto: List<VehicleDto> ->
                    val vehicles = vehiclesDto.map { vehicleDto: VehicleDto ->
                        vehicleDto.toVehicle()
                    }.toList()
                    return@withContext Resource.Success(data = vehicles)
                }
            }
            return@withContext Resource.Error(message = response.message())
        } catch (e: Exception) {
            return@withContext Resource.Error(message = e.message?: "An exception ocurred")
        }
    }

    suspend fun postVehicles(vehicleDto: VehicleDto): Resource<Vehicle> = withContext(Dispatchers.IO) {
        try {
            val response = service.postVehicle(vehicleDto)
            if (response.isSuccessful) {
                response.body()?.let {createdVehicle ->
                    return@withContext Resource.Success(createdVehicle.toVehicle())
                }
            }
            return@withContext Resource.Error(message = response.message())
        } catch (e: Exception) {
            return@withContext Resource.Error(message = e.message?: "An exception ocurred")
        }
    }

    suspend fun deleteVehicles(id: String): Result<Unit> {
        return try {
            val response = service.deleteVehicle(id)
            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                Result.failure(Exception("Error al eliminar el vehículo"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}