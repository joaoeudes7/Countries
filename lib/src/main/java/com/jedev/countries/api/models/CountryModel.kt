package com.jedev.countries.api.models

import com.google.gson.annotations.SerializedName

class CountryModel(
    val name: String,
    val idd: String?,
    val altSpellings: List<String>,
    val region: EnumRegionModel,
    val languages: List<String>?,
    val latLng: List<Double>,
    val area: Double,
    val flag: String,
    val population: Long,
    val tld: List<String>?,
    val postalCode: String?,
    val flags: FlagsModel,
    val translations: List<TranslationModel>,
    val continents: List<EnumContinentModel>,
    val subregion: String?,
    val maps: MapsModel,
    val timezones: List<String>,
    val capitalLatLng: List<Double>?
)

enum class EnumRegionModel(val value: String) {
    @SerializedName("Africa") Africa("Africa"),
    @SerializedName("Americas") Americas("Americas"),
    @SerializedName("Antarctic") Antarctic("Antarctic"),
    @SerializedName("Asia") Asia("Asia"),
    @SerializedName("Europe") Europe("Europe"),
    @SerializedName("Oceania") Oceania("Oceania");
}