import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinprojectloginpage.HomeScreen
import com.example.kotlinprojectloginpage.ui.theme.KotlinProjectLoginPageTheme
import com.example.kotlinprojectloginpage.SuccessScreen
import com.example.kotlinprojectloginpage.LoginScreen
import com.example.kotlinprojectloginpage.PasswordResetScreen
import com.example.kotlinprojectloginpage.RegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinProjectLoginPageTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") { HomeScreen(navController) }
                        composable("login") { LoginScreen(navController) }
                        composable("passwordReset") { PasswordResetScreen(navController) }
                        composable("register") { RegisterScreen(navController) }
                        composable("success") { SuccessScreen("Operation successful!", navController) }

                    }
                }
            }
        }
    }
}
