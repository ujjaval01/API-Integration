package com.uv.apiintegration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uv.apiintegration.screens.PostScreen
import com.uv.apiintegration.ui.theme.APIIntegrationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            APIIntegrationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { padding ->
                    PostScreen(
                        modifier = Modifier
                            .padding(padding)      // system + scaffold padding // 👈 extra top padding
                    )
                }

            }
        }
    }
}


