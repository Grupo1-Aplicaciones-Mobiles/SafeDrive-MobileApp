package com.example.mobileapp.features.vehicles.presentation.vehicleDetail

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddVehicleScreen(viewModel: VehicleDetailViewModel) {
    val state = viewModel.state.value
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {uri: Uri? ->
        uri?.let {
            viewModel.onImageUrlChanged(it.toString())
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Agregar vehículo: ", textAlign = TextAlign.Center) },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "Go Back",
                            modifier = Modifier.size(90.dp)
                        )
                    }
                }
            )
        }
    ) { paddingValues: PaddingValues ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            OutlinedTextField(value = viewModel.brandState.value, onValueChange = { brand ->
                viewModel.onBrandChanged(brand)
            }, label = { Text(text = "Marca") }, shape = RoundedCornerShape(10.dp), colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFBB86FC)
            ))
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(value = viewModel.modelState.value, onValueChange = { model ->
                viewModel.onModelChanged(model)
            }, label = { Text(text = "Modelo") }, shape = RoundedCornerShape(10.dp), colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFBB86FC)
            ))
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(value = viewModel.colorState.value, onValueChange = { color ->
                viewModel.onColorChanged(color)
            }, label = { Text(text = "Color") }, shape = RoundedCornerShape(10.dp), colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFBB86FC)
            ))
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(value = viewModel.plateState.value, onValueChange = { plate ->
                viewModel.onPlateChanged(plate)
            }, label = { Text(text = "Placa") }, shape = RoundedCornerShape(10.dp), colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFBB86FC)
            ))
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(value = viewModel.imageUrlState.value, onValueChange = { imageUrl ->
                viewModel.onImageUrlChanged(imageUrl)
            }, label = { Text(text = "Imagen") }, shape = RoundedCornerShape(10.dp), colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFBB86FC)
            ))
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(onClick = {
                launcher.launch("image/*")
            }) {
                Text(text = "Seleccionar Imagen")
            }

            Text(text = viewModel.imageUrlState.value)


            OutlinedButton(onClick = {
                viewModel.addVehicle()
            }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C63FF))) {
                Text(text = "Agregar")
            }
            if(state.isLoading) {
                CircularProgressIndicator()
            }
            state.data?.let {
                Text("Vehiculo agregado")
            }
        }
    }
}

