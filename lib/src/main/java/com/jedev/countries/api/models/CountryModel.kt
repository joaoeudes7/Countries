package com.jedev.countries.api.models

@Suppress("unused")
class CountryModel(
    val postalCode: PostalCode,
    val name: Name,
    val tld: List<String>,
    val currencies: List<Currency>,
    val idd: Idd,
    val altSpellings: List<String>,
    val region: String,
    val languages: List<String>,
    val latlng: List<Double>,
    val area: Double,
    val flag: String,
    val population: Long
)
