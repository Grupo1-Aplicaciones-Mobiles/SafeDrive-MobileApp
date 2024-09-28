package com.example.mobileapp.presentation.login

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobileapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onLoginClicked: () -> Unit){
    val logo: Painter = painterResource(id = R.drawable.logo) // Replace with actual resource
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(painter = logo, contentDescription = "Logo", modifier = Modifier.size(150.dp))

        Spacer(modifier = Modifier.height(16.dp))

        // Title
        Text(
            text = "Login",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
//        modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        // Subtitle
        Text(
            text = "Ingrese su usuario y contraseña\npara logearse",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
//        modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Username field
        OutlinedTextField(
            value = username,
            onValueChange = {newValue -> username = newValue },
            label = { Text("Username",color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedContainerColor = Color(0XFFDCD9FF),
                focusedContainerColor = Color(0XFFDCD9FF)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier.padding(end = 1.dp).fillMaxWidth()
        ) {
            ClickableText(
                text = AnnotatedString("Forgot Username?"),
                onClick = { println("Forgot username clicked") }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Password field
        OutlinedTextField(
            value = password,
            onValueChange = {newValue -> password = newValue},
            label = { Text("Password", color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0XFFDCD9FF),
                focusedTextColor = Color.Black
            )

        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier.padding(end = 1.dp).fillMaxWidth()
        ) {
            ClickableText(
                text = AnnotatedString("Forgot Password?"),
                onClick = { println("Forgot username clicked") }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Login button
        Button(
            onClick = { onLoginClicked() },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C63FF))
        ) {
            Text("Login", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Or login with text
        Text("Or log in with", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(8.dp))

        // Social login buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedButton(
                onClick = { /* Handle Google login */ },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                border = BorderStroke(1.dp, Color.Gray),

                ) {
                // Replace R.drawable.google_icon with your Google icon resource
                Image(painter = painterResource(id = R.drawable.google_logo), contentDescription = "Google",modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Google", color = Color.Black)
            }

            OutlinedButton(
                onClick = { /* Handle Facebook login */ },
                modifier = Modifier.weight(1f)
                    .padding(start = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4581B9))
            ) {
                // Replace R.drawable.facebook_icon with your Facebook icon resource
                Image(painter = painterResource(id = R.drawable.facebook), contentDescription = "Facebook",modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Facebook", color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Register text
        Row ( horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
            Text("Don't have an account? ", fontSize = 18.sp, color = Color.Black)
            ClickableText(
                text = AnnotatedString("Register"),
                onClick = { /* Handle register */ },
                style = androidx.compose.ui.text.TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            )
        }
    }
}