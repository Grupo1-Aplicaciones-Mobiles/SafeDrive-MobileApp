package com.example.mobileapp.features.vehicles.presentation.vehicleList

import android.view.ViewGroup
import android.widget.ImageView
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.example.mobileapp.features.vehicles.domain.Vehicle

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
                .padding(8.dp),
        ) {
            Text(text = vehicle.brand, style = MaterialTheme.typography.bodyLarge)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                AndroidView(
                    factory = { context ->
                        ImageView(context).apply {
                            layoutParams = ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                (100 * context.resources.displayMetrics.density).toInt()
                            )
                        }
                    },
                    update = { imageView ->
                        Glide.with(imageView.context)
                            .load(vehicle.imageUri)
                            .into(imageView)
                    },
                    modifier = Modifier.size(150.dp, 100.dp)
                )
                Spacer(modifier = Modifier.size(130.dp))
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

