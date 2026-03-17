package com.oscarpino.economic_indicators.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.oscarpino.common.toDateString
import com.oscarpino.domain.model.Indicator
import com.oscarpino.economic_indicators.feature.indicators.presentation.intent.IndicatorIntent
import com.oscarpino.economic_indicators.feature.indicators.presentation.viewmodel.IndicatorViewModel
import com.oscarpino.economic_indicators.ui.theme.Economic_indicatorsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IndicatorScreen()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Economic_indicatorsTheme {
        Greeting("Android")
    }
}

@Composable
fun IndicatorScreen(viewModel: IndicatorViewModel = hiltViewModel()) {

    val state = viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.sendIntent(IndicatorIntent.GetIndicatorsIntent)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Text(text = "Indicadores", color = Color.White, fontSize = 22.sp)
            }
        }
    ) { padding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .padding(16.dp)
                .padding(padding)
        ) {
            items(
                items = state.value.indicatorList,
                itemContent = { indicator ->
                    ItemIndicator(indicator)
                }
            )
        }
    }
}

@Composable
fun ItemIndicator(indicator: Indicator) {
    Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(
                text = indicator.name,
                maxLines = 1,
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )

            Text(
                text = indicator.value.toString(),
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )

            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = indicator.date.toDateString(),
                    color = Color.Gray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}


//que se repite? y son las 3am :(
