package com.example.mobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobileapp.ui.theme.MobileAppTheme
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.mobileapp.ui.theme.BackgroundColor

import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { paddingValues: PaddingValues ->    //Elementos Iniciales Importantes
                    Column(                                   //Elementos Iniciales Importantes
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)

                        ,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally   //Elementos Iniciales Importantes
                    ) { //Aqui se pone como tal la vista y funciones que conformaran la vista
                        Profile2()
                    }
                }
        }
    }
}

@Composable
fun MyNavigationBar() {
    Column {
        // Divider separado arriba de la barra de navegación
        Divider(
            color = Color(0xFF6C63FF),  // Color de la línea
            thickness = 5.dp,    // Grosor de la línea
        )

        // NavigationBar
        NavigationBar(
            containerColor = Color.White,
            contentColor = Color.Black,

        ) {
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Home, contentDescription = "Home", modifier = Modifier.size(50.dp)) },
                label = { Text("Home", fontSize = 12.sp) },
                selected = false,
                onClick = { /* Acción cuando se selecciona */ }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Place, contentDescription = "Rastreo", modifier = Modifier.size(50.dp)) },
                label = { Text("Rastreo", fontSize = 12.sp) },
                selected = false,
                onClick = { /* Acción cuando se selecciona */ }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Warning, contentDescription = "Avisos", modifier = Modifier.size(50.dp)) },
                label = { Text("Avisos", fontSize = 12.sp) },
                selected = false,
                onClick = { /* Acción cuando se selecciona */ }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Person, contentDescription = "Perfil", modifier = Modifier.size(50.dp)) },
                label = { Text("Perfil", fontSize = 12.sp) },
                selected = false,
                onClick = { /* Acción cuando se selecciona */ }
            )
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login1() {
    val logo: Painter = painterResource(id = R.drawable.logo) // Replace with actual resource
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
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
//        modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        // Subtitle
        Text(
            text = "Ingrese su usuario y contraseña\npara logearse",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
//        modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Username field
        OutlinedTextField(
            value = username,
            onValueChange = {newValue -> username = newValue },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0XFFDCD9FF)
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
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0XFFDCD9FF)
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
            onClick = { /* Handle login action */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C63FF))
        ) {
            Text("Login", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Or login with text
        Text("Or login in with", fontWeight = FontWeight.Bold, fontSize = 20.sp)

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
            Text("Don't have an account? ", fontSize = 18.sp)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login2(){
    val logo: Painter = painterResource(id = R.drawable.logo) // Replace with actual resource
    // Estados de entrada
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
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
//        modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        // Subtitle
        Text(
            text = "Llene los siguientes campos de registro",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
//        modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Username field
        OutlinedTextField(
            value = name,
            onValueChange = {newValue -> name = newValue },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth(),
            isError = nameError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0XFFDCD9FF),
                focusedBorderColor = if (nameError) Color.Red else Color(0xFF6C63FF),
                unfocusedBorderColor = if (nameError) Color.Red else Color.Gray
            )
        )
        if (nameError) {
            Text("Please enter your name", color = Color.Red, fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {newValue -> email = newValue },
            label = { Text("Email Adress") },
            modifier = Modifier.fillMaxWidth(),
            isError = emailError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0XFFDCD9FF),
                focusedBorderColor = if (emailError) Color.Red else Color(0xFF6C63FF),
                unfocusedBorderColor = if (emailError) Color.Red else Color.Gray
            )
        )

        if (emailError) {
            Text("Please enter your email", color = Color.Red, fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = number,
            onValueChange = {newValue -> number = newValue },
            label = { Text("Mobile Number") },
            modifier = Modifier.fillMaxWidth(),
            isError = numberError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0XFFDCD9FF),
                focusedBorderColor = if (numberError) Color.Red else Color(0xFF6C63FF),
                unfocusedBorderColor = if (numberError) Color.Red else Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {newValue -> password = newValue },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            isError = passwordError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0XFFDCD9FF),
                focusedBorderColor = if (passwordError) Color.Red else Color(0xFF6C63FF),
                unfocusedBorderColor = if (passwordError) Color.Red else Color.Gray
            )
        )

        if (passwordError) {
            Text(passwordErrorMessage, color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {newValue -> password = newValue },
            label = { Text("Confirm Password") },
            modifier = Modifier.fillMaxWidth(),
            isError = passwordError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0XFFDCD9FF),
                focusedBorderColor = if (passwordError) Color.Red else Color(0xFF6C63FF),
                unfocusedBorderColor = if (passwordError) Color.Red else Color.Gray
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile2() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    val logo: Painter = painterResource(id = R.drawable.profile) // Replace with actual resource

    Scaffold(
        bottomBar = { MyNavigationBar() },
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
                        .fillMaxSize()
                        .padding(horizontal = 25.dp),
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
                    Text(text = "New Name: ", fontSize = 30.sp, fontWeight = FontWeight.Bold)
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
                    Text(text = "New Email: ", fontSize = 30.sp, fontWeight = FontWeight.Bold)
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
                    Text(text = "New Phone Number: ", fontSize = 30.sp, fontWeight = FontWeight.Bold)
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





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobileAppTheme {
        Login1()
    }
}