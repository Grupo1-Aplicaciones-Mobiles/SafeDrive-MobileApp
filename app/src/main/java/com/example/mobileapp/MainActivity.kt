package com.example.mobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mobileapp.features.vehicles.common.Constants
import com.example.mobileapp.features.vehicles.data.remote.VehicleService
import com.example.mobileapp.features.vehicles.data.repository.VehicleRepository
import com.example.mobileapp.features.vehicles.presentation.vehicleDetail.AddVehicleScreen
import com.example.mobileapp.features.vehicles.presentation.vehicleDetail.VehicleDetailViewModel
import com.example.mobileapp.features.vehicles.presentation.vehicleList.VehicleListScreen
import com.example.mobileapp.features.vehicles.presentation.vehicleList.VehicleListViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VehicleService::class.java)
        val repository = VehicleRepository(retrofit)
        val viewModel = VehicleListViewModel(repository)
        val viewmodel2 = VehicleDetailViewModel(repository)
        setContent {
            AddVehicleScreen(viewmodel2)
            //VehicleListScreen(viewModel)
        }
    }
}