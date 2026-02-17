package com.pumaazteca.tifofan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.pumaazteca.tifofan.ui.theme.TifoFanTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)

        var isLoading = true

        splashScreen.setKeepOnScreenCondition {
            isLoading
        }

        // Simulate loading
        lifecycleScope.launch {
            delay(2000)
            isLoading = false
        }

        enableEdgeToEdge()
        setContent {
            TifoFanTheme {
                MainScreen()

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomTabViewPreview() {
    MainScreen()
}