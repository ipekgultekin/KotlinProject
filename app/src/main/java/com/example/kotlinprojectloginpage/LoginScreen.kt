package com.example.kotlinprojectloginpage

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinprojectloginpage.R

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    // Sabit boyutlar
    val textSizeWelcome = 28.sp
    val textSizeLogin = 16.sp
    val textSizeForgotPassword = 14.sp
    val buttonSize = 50.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.loginpage),
            contentDescription = "Login image",
            modifier = Modifier.size(screenWidth * 0.5f)  // Ekranın %50'si kadar
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Welcome",
            fontSize = textSizeWelcome,  // Sabit metin boyutu
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Login to your account",
            fontSize = textSizeLogin  // Sabit metin boyutu
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email address") },
            modifier = Modifier
                .fillMaxWidth(0.9f)  // Ekranın %90'ı kadar genişlik
                .height(56.dp)  // Sabit yükseklik
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth(0.9f)  // Ekranın %90'ı kadar genişlik
                .height(56.dp)  // Sabit yükseklik
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { Log.i("Credential", "Email: $email Password: $password") },
            modifier = Modifier
                .fillMaxWidth(0.9f)  // Ekranın %90'ı kadar genişlik
                .height(buttonSize)  // Sabit yükseklik
        ) {
            Text(text = "Login", fontSize = textSizeLogin)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Forgot Password?",
            modifier = Modifier.clickable { /* Forgot Password logic */ },
            fontSize = textSizeForgotPassword
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Or sign in with", fontSize = textSizeForgotPassword)

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.googlepng),
            contentDescription = "Google",
            modifier = Modifier
                .size(screenWidth * 0.15f)  // Ekranın %15'i kadar
                .clickable { /* Google sign-in logic */ }
        )
    }
}
