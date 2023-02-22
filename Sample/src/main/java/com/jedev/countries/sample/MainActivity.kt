package com.jedev.countries.sample

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jedev.countries.api.CountriesClient
import com.jedev.countries.api.models.CountryModel
import com.jedev.countries.sample.ui.theme.CountriesApiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountriesApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SampleListCountry(application)
                }
            }
        }
    }
}

@Composable
fun SampleListCountry(application: Application) {
    // Example of using the library
    // You should use a DI and ViewModel in a real app
    val countryClient by remember {
        mutableStateOf(CountriesClient(application))
    }

    var countries by remember { mutableStateOf(listOf<CountryModel>()) }

    LaunchedEffect(Unit) {
        countries = countryClient.getAll()
    }

    LazyColumn(Modifier.fillMaxWidth()) {
        items(countries, key = { it.name }) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                text = it.name,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

