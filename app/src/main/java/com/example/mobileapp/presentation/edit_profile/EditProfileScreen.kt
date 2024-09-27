package com.example.mobileapp.presentation.edit_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobileapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    val logo: Painter = painterResource(id = R.drawable.profile) // Replace with actual resource

    Scaffold(
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFDCD9FF))
                    .padding(padding)
                    .padding(horizontal = 25.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                ) {
                    // Imagen y botón de editar
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(painter = logo, contentDescription = "Logo", modifier = Modifier.size(150.dp))
                        Spacer(modifier = Modifier.width(16.dp))
                        Box(
                            modifier = Modifier
                                .size(55.dp)
                                .background(Color.Gray, CircleShape)
                        ) {
                            IconButton(
                                onClick = {},
                                modifier = Modifier.align(Alignment.Center)
                            ) {
                                Icon(
                                    Icons.Filled.Edit,
                                    contentDescription = "Change Photo",
                                    tint = Color.Black,
                                    modifier = Modifier.size(40.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "New Name: ", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.Black) // Texto rojo
                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = name,
                        onValueChange = { newValue -> name = newValue },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "New Email: ", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { newValue -> email = newValue },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "New Phone Number: ", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = phone,
                        onValueChange = { newValue -> phone = newValue },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { /* Handle save action */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C63FF))
                    ) {
                        Text("Save", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }
                }
            }
        }
    )
}