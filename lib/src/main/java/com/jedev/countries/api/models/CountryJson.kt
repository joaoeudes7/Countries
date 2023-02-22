package com.jedev.countries.api.models


data class CountryJsonObject (
    val postalCode: PostalCode,
    val name: Name,
    val tld: List<String>,
    val currencies: Map<String, Currency>,
    val idd: Idd,
    val altSpellings: List<String>,
    val region: String,
    val languages: Map<String, String>,
    val latlng: List<Double>,
    val area: Double,
    val flag: String,
    val population: Long
)

data class Currency (
    val name: String,
    val symbol: String
)

data class Idd (
    val root: String,
    val suffixes: List<String>
)

data class Name (
    val common: String,
    val official: String,
    val nativeName: Map<String, NativeName>
)

data class NativeName (
    val official: String,
    val common: String
)

data class PostalCode (
    val format: String? = null,
    val regex: String? = null
)
