package com.example.kotlinprojectloginpage

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun RegisterScreen(navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val textSizeWelcome = 28.sp
    val textSizeLogin = 16.sp
    val textSizeForgotPassword = 14.sp
    val buttonSize = 50.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Back button using Material Icons
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 48.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.register),
                contentDescription = "Register image",
                modifier = Modifier.size(screenWidth * 0.5f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Create Your Account",
                fontSize = textSizeWelcome,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text(text = "Name-Surname") },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Email address") },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("success") },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(buttonSize),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC0CB))
            ) {
                Text(text = "Sign Up", fontSize = textSizeLogin)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Or sign up with", fontSize = textSizeForgotPassword, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.googlepng),
                contentDescription = "Google",
                modifier = Modifier
                    .size(screenWidth * 0.15f)
                    .clickable { /* Google sign-up logic */ }
            )
        }
    }
}