package com.example.mobileapp.features.vehicles.presentation.vehicleDetail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapp.features.vehicles.common.Resource
import com.example.mobileapp.features.vehicles.common.UIState
import com.example.mobileapp.features.vehicles.data.remote.dto.VehicleDto
import com.example.mobileapp.features.vehicles.data.repository.VehicleRepository
import com.example.mobileapp.features.vehicles.domain.Vehicle
import kotlinx.coroutines.launch

class VehicleDetailViewModel(private val repository: VehicleRepository): ViewModel() {
    private val _state = mutableStateOf(UIState<Vehicle>())
    val state: State<UIState<Vehicle>> get() = _state

    private val _id = mutableStateOf("")
    val idState: State<String> get() = _id

    private val _brand = mutableStateOf("")
    val brandState: State<String> get() = _brand

    private val _model = mutableStateOf("")
    val modelState: State<String> get() = _model

    private val _color = mutableStateOf("")
    val colorState: State<String> get() = _color

    private val _plate = mutableStateOf("")
    val plateState: State<String> get() = _plate

    private val _imageUrl = mutableStateOf("")
    val imageUrlState: State<String> get() = _imageUrl

    fun onBrandChanged(brand: String) {
        _brand.value = brand
    }

    fun onModelChanged(model: String) {
        _model.value = model
    }

    fun onColorChanged(color: String) {
        _color.value = color
    }

    fun onPlateChanged(plate: String) {
        _plate.value = plate
    }

    fun onImageUrlChanged(imageUrl: String) {
        _imageUrl.value = imageUrl
    }

    fun addVehicle() {
        viewModelScope.launch {
            _state.value = UIState(isLoading = true)
            val vehicle = VehicleDto(
                brand = _brand.value,
                model = _model.value,
                color = _color.value,
                plate = _plate.value,
                imageUrl = _imageUrl.value
            )

            val result = repository.postVehicles(vehicle)
            when (result) {
                is Resource.Success -> {  // Maneja el caso de éxito
                    val addedVehicle = result.data // Aquí debería ser de tipo Vehicle
                    _state.value = UIState(data = addedVehicle)  // Almacena el Vehicle completo
                    Log.d("VehicleDetailViewModel", "Vehicle added successfully: $addedVehicle")
                }
                is Resource.Error -> {  // Maneja el caso de error
                    _state.value = UIState(message = result.message ?: "Error al agregar vehículo")
                    Log.e("VehicleDetailViewModel", "Failed to add vehicle: ${result.message}")
                }
            }
        }
    }
}

