package com.example.mobileapp.presentation.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
fun RegisterScreen(){
    val scrollState = rememberScrollState() // Estado del scroll
    val logo: Painter = painterResource(id = R.drawable.logo) // Replace with actual resource
    // Estados de entrada
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }

    // Estados de error
    var nameError by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var numberError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    var passwordErrorMessage by remember { mutableStateOf("") }

    // Expresión regular para validar al menos un número o carácter especial
    val passwordPattern = Regex("^(?=.*[0-9])(?=.*[!@#\$%^&*()_+]).{8,}\$")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Color.White)
            .padding(horizontal = 25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = logo, contentDescription = "Logo", modifier = Modifier.size(150.dp))

        Spacer(modifier = Modifier.height(16.dp))

        // Title
        Text(
            text = "Registro",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
//        modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        // Subtitle
        Text(
            text = "Llene los siguientes campos de registro",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
//        modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Username field
        OutlinedTextField(
            value = name,
            onValueChange = {newValue -> name = newValue },
            label = { Text("Name",color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            isError = nameError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0XFFDCD9FF),
                focusedBorderColor = if (nameError) Color.Red else Color(0xFF6C63FF),
                unfocusedBorderColor = if (nameError) Color.Red else Color.Gray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                errorTextColor = Color.Black
            )
        )
        if (nameError) {
            Text("Please enter your name", color = Color.Red, fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {newValue -> email = newValue },
            label = { Text("Email Adress",color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            isError = emailError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0XFFDCD9FF),
                focusedBorderColor = if (emailError) Color.Red else Color(0xFF6C63FF),
                unfocusedBorderColor = if (emailError) Color.Red else Color.Gray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                errorTextColor = Color.Black
            )
        )

        if (emailError) {
            Text("Please enter your email", color = Color.Red, fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = number,
            onValueChange = {newValue -> number = newValue },
            label = { Text("Mobile Number",color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            isError = numberError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0XFFDCD9FF),
                focusedBorderColor = if (numberError) Color.Red else Color(0xFF6C63FF),
                unfocusedBorderColor = if (numberError) Color.Red else Color.Gray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                errorTextColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {newValue -> password = newValue },
            label = { Text("Password",color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            isError = passwordError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0XFFDCD9FF),
                focusedBorderColor = if (passwordError) Color.Red else Color(0xFF6C63FF),
                unfocusedBorderColor = if (passwordError) Color.Red else Color.Gray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                errorTextColor = Color.Black
            )
        )

        if (passwordError) {
            Text(passwordErrorMessage, color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {newValue -> confirmPassword = newValue },
            label = { Text("Confirm Password",color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            isError = passwordError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0XFFDCD9FF),
                focusedBorderColor = if (passwordError) Color.Red else Color(0xFF6C63FF),
                unfocusedBorderColor = if (passwordError) Color.Red else Color.Gray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                errorTextColor = Color.Black
            )
        )
        if (passwordError) {
            Text("Please confirm your password", color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF6C63FF), // Color del checkbox cuando está marcado
                    uncheckedColor = Color.Gray // Color del checkbox cuando no está marcado
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            ClickableText(
                text = AnnotatedString("Estoy de acuerdo con los términos y condiciones"),
                onClick = { /* Acción al hacer clic en el texto */ },
                style = androidx.compose.ui.text.TextStyle(fontSize = 16.sp)
            )
        }

        // Botón "Next"
        Button(
            onClick = {  nameError = name.isEmpty()
                emailError = email.isEmpty()
                numberError = number.isEmpty()

                if (password.isEmpty() || !password.matches(passwordPattern)) {
                    passwordError = true
                    passwordErrorMessage = "Must be 8 or more characters and contain at least 1 number or special character"
                } else {
                    passwordError = false
                    passwordErrorMessage = ""
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C63FF)) // Color del botón
        ) {
            Text("Next", color = Color.White, fontSize = 18.sp)
        }
    }
}