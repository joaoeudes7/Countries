package com.jedev.countries.api.models

@Suppress("unused")
class CountryModel(
    val name: String,
    val idd: String?,
    val altSpellings: List<String>,
    val region: String,
    val languages: List<String>?,
    val latlng: List<Double>,
    val area: Double,
    val flag: String,
    val population: Long,
    val tld: List<String>?,
    val postalCode: String?
)

data class CurrencyModel (
    val name: String,
    val symbol: String
)
