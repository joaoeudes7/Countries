package com.jedev.countries.api.models

import com.google.gson.annotations.SerializedName

typealias CountriesJsonRes = List<CountryJsonRes>
data class CountryJsonRes (
    @SerializedName("postalCode")
    val postalCode: PostalCodeJsonRes? = null,
    val name: NameJsonRes,
    val tld: List<String>? = null,
    val idd: IddResJson? = null,
    val altSpellings: List<String>,
    val languages: Map<String, String>?,
    val region: String,
    val latlng: List<Double>,
    val area: Double,
    val flag: String,
    val population: Long
)

data class Currency (
    val name: String,
    val symbol: String
)

data class IddResJson (
    val root: String,
    val suffixes: List<String>?
) {
    val iddGeneral: String
        get() = root + (suffixes?.firstOrNull() ?: "")
}

data class NameJsonRes (
    val common: String,
    val official: String,
    val nativeName: Map<String, NativeNameJsonRes>
)
data class NativeNameJsonRes (
    val official: String,
    val common: String
)

data class PostalCodeJsonRes (
    val format: String? = null,
    val regex: String? = null
)
