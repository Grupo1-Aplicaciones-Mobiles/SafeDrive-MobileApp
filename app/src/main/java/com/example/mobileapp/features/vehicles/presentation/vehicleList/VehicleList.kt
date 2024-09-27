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
import com.bumptech.glide.Glide
import com.example.mobileapp.features.vehicles.domain.Vehicle
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VehicleListScreen(
    viewModel: VehicleListViewModel
) {
    val state = viewModel.state.value
    val modelState = viewModel.brand.value


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Vehículos") },
                actions = {
                    IconButton(onClick = {}) {
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
        state.data?.let { vehicles ->
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(vehicles) { vehicle ->
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

