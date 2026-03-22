package com.oscarpino.economic_indicators.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oscarpino.economic_indicators.feature.indicators.ui.views.DetailScreen
import com.oscarpino.economic_indicators.feature.indicators.ui.views.IndicatorScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                modifier = Modifier.fillMaxSize(),
                navController = navController,
                startDestination = "detail"
            ) {
                composable("detail") {
                    DetailScreen(
                        goToIndicators = {
                            navController.navigate("list")
                        }
                    )
                }

                composable("list") {
                    IndicatorScreen()
                }
            }
        }
    }
}




