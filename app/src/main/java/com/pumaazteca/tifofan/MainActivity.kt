package com.pumaazteca.tifofan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pumaazteca.tifofan.ui.theme.TifoFanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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