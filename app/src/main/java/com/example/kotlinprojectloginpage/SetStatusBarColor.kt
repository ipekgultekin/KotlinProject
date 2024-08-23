import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SetStatusBarColor() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = true // Status bar ikonları beyaz olduğu için true yapıyoruz.
    val color = Color.White

    systemUiController.setSystemBarsColor(
        color = color,
        darkIcons = useDarkIcons
    )
}
