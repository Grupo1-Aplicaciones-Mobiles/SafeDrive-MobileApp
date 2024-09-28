package com.example.mobileapp.features.vehicles.presentation.vehicleDetail

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.mobileapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddVehicleScreen(goBack: () -> Unit = {}, viewModel: VehicleDetailViewModel = viewModel()) {
    val state = viewModel.state.value
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {uri: Uri? ->
        viewModel.onImageUriChanged(uri)
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Agregar vehículo: ", textAlign = TextAlign.Center) },
                actions = {
                    IconButton(onClick = {goBack()}) {
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
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(start = 24.dp)
        ) {
            OutlinedTextField(value = viewModel.brandState.value, onValueChange = { brand ->
                viewModel.onBrandChanged(brand)
            }, label = { Text(text = "Marca", color = Color.Black) }, shape = RoundedCornerShape(10.dp), colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFBB86FC)
            ))
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(value = viewModel.modelState.value, onValueChange = { model ->
                viewModel.onModelChanged(model)
            }, label = { Text(text = "Modelo", color = Color.Black) }, shape = RoundedCornerShape(10.dp), colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFBB86FC)
            ))
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(value = viewModel.colorState.value, onValueChange = { color ->
                viewModel.onColorChanged(color)
            }, label = { Text(text = "Color", color = Color.Black) }, shape = RoundedCornerShape(10.dp), colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFBB86FC)
            ))
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(value = viewModel.plateState.value, onValueChange = { plate ->
                viewModel.onPlateChanged(plate)
            }, label = { Text(text = "Placa", color = Color.Black) }, shape = RoundedCornerShape(10.dp), colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFBB86FC)
            ))

            Spacer(modifier = Modifier.height(16.dp))

            val painter: Painter = if (viewModel.imageUriState.value != null) {
                rememberAsyncImagePainter(viewModel.imageUriState.value)
            } else {
                painterResource(id = R.drawable.image_svgrepo_com)
            }

            Image(
                painter = painter,
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(200.dp).width(350.dp).border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)).clickable {
                    launcher.launch("image/*")
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(onClick = {
                viewModel.imageUriState.value?.let { uri ->
                    viewModel.addVehicle(uri)
                }
            }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C63FF)),
                modifier = Modifier.fillMaxWidth().padding(end = 24.dp)) {
                Text(text = "Agregar")
            }
            if(state.isLoading) {
                CircularProgressIndicator()
            }
            state.data?.let {
                Toast.makeText(
                    context, "Vehículo agregado correctamente",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

