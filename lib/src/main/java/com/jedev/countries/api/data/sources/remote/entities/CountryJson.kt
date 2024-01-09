package com.jedev.countries.api.data.sources.remote.entities

import com.google.gson.annotations.SerializedName

typealias CountriesJsonRes = List<CountryJsonRes>
data class CountryJsonRes (
    @SerializedName("postalCode")
    val postalCode: PostalCodeJsonRes? = null,
    @SerializedName("name")
    val name: NameJsonRes,
    @SerializedName("tld")
    val tld: List<String>? = null,
    @SerializedName("idd")
    val idd: IddResJson? = null,
    @SerializedName("altSpellings")
    val altSpellings: List<String>,
    @SerializedName("languages")
    val languages: Map<String, String>?,
    @SerializedName("region")
    val region: String,
    @SerializedName("latlng")
    val latlng: List<Double>,
    @SerializedName("area")
    val area: Double,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("population")
    val population: Long
)

data class IddResJson (
    @SerializedName("root")
    val root: String,
    @SerializedName("suffixes")
    val suffixes: List<String>?
) {
    val iddGeneral: String
        get() = root + (suffixes?.firstOrNull() ?: "")
}

data class NameJsonRes (
    @SerializedName("common")
    val common: String,
    @SerializedName("official")
    val official: String,
    @SerializedName("nativeName")
    val nativeName: Map<String, NativeNameJsonRes>
)
data class NativeNameJsonRes (
    @SerializedName("official")
    val official: String,
    @SerializedName("common")
    val common: String
)

data class PostalCodeJsonRes (
    @SerializedName("format")
    val format: String? = null,
    @SerializedName("regex")
    val regex: String? = null
)
