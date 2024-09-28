package com.example.mobileapp.features.vehicles.presentation.vehicleList

import android.view.ViewGroup
import android.widget.ImageView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.Glide
import com.example.mobileapp.features.vehicles.domain.Vehicle
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VehicleListScreen(openAddVehicle: () -> Unit = {}, viewModel: VehicleListViewModel = viewModel()) {

    val state = viewModel.state.value
    val modelState = viewModel.brand.value

    val vehicles = listOf(
        Vehicle("1", "McLaren Angga", "Supercar", "Naranja", "ABC-123", "https://i.pinimg.com/originals/02/aa/09/02aa0984b7f864e78ac126908a083703.jpg"),
        Vehicle("2", "Mazda", "CX-9", "Rojo", "BCE-321", "https://derco-pe-prod.s3.amazonaws.com/images/versions/2022-01-13-CX_9_4.png"),
        Vehicle("3", "Mitsubishi", "Xpander", "Blanco", "DEF-345", "https://autoland.com.pe/wp-content/uploads/2020/11/4-All-New-Xpander.png"),
        Vehicle("4", "Toyota", "Rush", "Rojo", "BBG-556", "https://www.mitsuiautomotriz.com/sites/default/files/2023-02/CONOCELOS_TOYOTA_Rush-02.jpg"),
        Vehicle("5", "Toyota", "Yaris", "Blanco", "FFR-443", "https://www.toyotaperu.com.pe/toyota-a-gas/assets/img/modelo/yaris-auto-glp.jpg"),
        Vehicle("6", "Ferrari", "458 Italia", "Rojo", "HHR-677", "https://cdn.ferrari.com/cms/network/media/img/resize/5db98e9b8c92940b3a3de720-ferrari-458-italia-design-focus-1?"),
        Vehicle("7", "Lamborghini", "Aventador", "Verde", "LLG-698", "https://cdn.motor1.com/images/mgl/Q8bqN/s1/lamborghini-aventador-svj.webp")
    )


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Vehículos") },
                actions = {
                    IconButton(onClick = { openAddVehicle() }) {
                        Icon(
                            Icons.Filled.AddCircle,
                            contentDescription = "Add Vehicle",
                            modifier = Modifier.size(150.dp)
                        )
                    }
                }
            )
        }
    ) { paddingValues: PaddingValues ->
        if (state.isLoading) {
            CircularProgressIndicator()
        }
        if (state.message.isNotEmpty()) {
            Text(text = "Error: ${state.message}", color = Color.Red)
        }
        vehicles.let { vehicle ->
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(vehicle) { vehicle ->
                    VehicleItem(vehicle, onDeleteClick = {
                        viewModel.deleteVehicle(vehicle.id)
                    })
                }
            }
        }
    }
}

    @Composable
    fun VehicleItem(vehicle: Vehicle, onDeleteClick: () -> Unit) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                GlideImage(
                    modifier = Modifier.size(120.dp),
                    imageModel = { vehicle.imageUri },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )
                )
                Column(modifier = Modifier
                    .padding(4.dp)
                    .weight(1f)) {
                    Text(text = vehicle.brand, fontSize = 20.sp)
                    Text(text = vehicle.model)
                    Text(text = vehicle.plate)
                }
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Edit,
                        contentDescription = "Edit",
                        modifier = Modifier.size(200.dp)
                    )
                }
                IconButton(onClick = { onDeleteClick() }) {
                    Icon(
                        Icons.Default.Delete,
                        contentDescription = "Delete",
                        modifier = Modifier.size(200.dp)
                    )
                }
            }
        }
    }

