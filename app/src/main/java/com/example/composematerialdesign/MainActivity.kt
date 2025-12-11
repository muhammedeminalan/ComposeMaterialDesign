package com.example.composematerialdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.composematerialdesign.components.navigation.BottomNavigationBar
import com.example.composematerialdesign.components.topbar.TopBar
import com.example.composematerialdesign.screens.ComponentsShowcaseScreen
import com.example.composematerialdesign.screens.MainScreen
import com.example.composematerialdesign.ui.theme.ComposeMaterialDesignTheme

/**
 * Ana Activity sınıfı
 * Uygulamanın giriş noktası - Edge-to-edge görünüm ve Material Design tema uygular
 * BottomNavigationBar ile iki sayfa arasında geçiş sağlar
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMaterialDesignTheme {
                var selectedTab by remember { mutableStateOf(0) }

                Scaffold(
                    topBar = {
                        TopBar(
                            title = if (selectedTab == 0) "Card Showcase" else "Components"
                        )
                    },
                    bottomBar = {
                        BottomNavigationBar(
                            selectedIndex = selectedTab,
                            onItemSelected = { selectedTab = it }
                        )
                    }
                ) { innerPadding ->
                    when (selectedTab) {
                        0 -> MainScreen(modifier = Modifier.padding(innerPadding))
                        1 -> ComponentsShowcaseScreen(modifier = Modifier.padding(innerPadding))
                        else -> MainScreen(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

