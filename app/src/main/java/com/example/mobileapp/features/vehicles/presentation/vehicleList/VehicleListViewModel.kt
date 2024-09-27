package com.example.mobileapp.features.vehicles.presentation.vehicleList

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapp.features.vehicles.common.Resource
import com.example.mobileapp.features.vehicles.common.UIState
import com.example.mobileapp.features.vehicles.data.repository.VehicleRepository
import com.example.mobileapp.features.vehicles.domain.Vehicle
import kotlinx.coroutines.launch

class VehicleListViewModel(private val repository: VehicleRepository): ViewModel() {
    private val _state = mutableStateOf(UIState<List<Vehicle>>())
    val state: State<UIState<List<Vehicle>>> get() = _state

    private val _brand = mutableStateOf("")
    val brand: State<String> get() = _brand

    init {
        getVehicles()
    }

    private fun getVehicles() {
        _state.value = UIState(isLoading = true)

        viewModelScope.launch {
            val result = repository.getVehicles()
            if (result is Resource.Success) {
                _state.value = UIState(data = result.data)
                Log.d("VehicleListViewModel", "Vehicles fetched: ${result.data}")
            } else {
                _state.value = UIState(message = result.message ?: "An error ocurred")
                Log.d("VehicleListViewModel", "Error fetching vehicles: ${result.message}")
            }
        }
    }

    fun deleteVehicle(id: String) {
        _state.value = UIState(isLoading = true)

        viewModelScope.launch {
            val result = repository.deleteVehicles(id)
            result.onSuccess {
                _state.value = UIState(message = "Vehículo eliminado correctamente")
                getVehicles()
                Log.d("VehicleDetailViewModel", "Vehicle deleted successfully")
            }.onFailure {
                _state.value = UIState(message = it.message ?: "Error al eliminar vehículo")
                Log.e("VehicleDetailViewModel", "Failed to delete vehicle $id: ${it.message}")
            }
        }
    }


    fun onBrandChanged(brand: String) {
        _brand.value = brand
        getVehicles()
    }
}