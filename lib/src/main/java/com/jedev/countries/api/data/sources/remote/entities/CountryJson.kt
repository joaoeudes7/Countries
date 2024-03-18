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
    val region: RegionResJson,
    @SerializedName("subregion")
    val subregion: String? = null,
    @SerializedName("latlng")
    val latlng: List<Double>,
    @SerializedName("area")
    val area: Double,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("population")
    val population: Long,
    @SerializedName("currencies")
    val currencies: Map<String, CurrencyResJson>? = null,
    @SerializedName("maps")
    val maps: MapsResJson,
    @SerializedName("fifa")
    val fifa: String? = null,
    @SerializedName("car")
    val car: CarResJson,
    @SerializedName("timezones")
    val timezones: List<String>,
    @SerializedName("continents")
    val continents: List<ContinentResJson>,
    @SerializedName("flags")
    val flags: FlagsResJson,
    @SerializedName("translations")
    val translations: Map<String, TranslationResJson>,
    @SerializedName("coatOfArms")
    val coatOfArms: CoatOfArmsResJson,
    @SerializedName("startOfWeek")
    val startOfWeek: StartOfWeek,
    @SerializedName("capitalInfo")
    val capitalInfo: CapitalInfoResJson,
    @SerializedName("gini")
    val gini: Map<String, Double>? = null
)

data class CapitalInfoResJson (
    @SerializedName("latlng")
    val latlng: List<Double>? = null
)

data class CarResJson (
    @SerializedName("signs")
    val signs: List<String>? = null,
    @SerializedName("side")
    val side: SideResJson
)

enum class SideResJson(val value: String) {
    @SerializedName("left")
    Left("left"),
    @SerializedName("right")
    Right("right");
}

data class CoatOfArmsResJson (
    @SerializedName("png")
    val png: String? = null,
    @SerializedName("svg")
    val svg: String? = null
)

enum class ContinentResJson(val value: String) {
    @SerializedName("Africa")
    Africa("Africa"),
    @SerializedName("Antarctica")
    Antarctica("Antarctica"),
    @SerializedName("Asia")
    Asia("Asia"),
    @SerializedName("Europe")
    Europe("Europe"),
    @SerializedName("North America")
    NorthAmerica("North America"),
    @SerializedName("Oceania")
    Oceania("Oceania"),
    @SerializedName("South America")
    SouthAmerica("South America");
}

data class CurrencyResJson (
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String?
)

data class FlagsResJson (
    @SerializedName("png")
    val png: String,
    @SerializedName("svg")
    val svg: String,
    @SerializedName("alt")
    val alt: String? = null
)

data class MapsResJson (
    @SerializedName("googleMaps")
    val googleMaps: String,
    @SerializedName("openStreetMaps")
    val openStreetMaps: String
)


data class TranslationResJson (
    @SerializedName("official")
    val official: String,
    @SerializedName("common")
    val common: String
)

enum class RegionResJson(val value: String) {
    @SerializedName("Africa") Africa("Africa"),
    @SerializedName("Americas") Americas("Americas"),
    @SerializedName("Antarctic") Antarctic("Antarctic"),
    @SerializedName("Asia") Asia("Asia"),
    @SerializedName("Europe") Europe("Europe"),
    @SerializedName("Oceania") Oceania("Oceania");
}


enum class StartOfWeek(val value: String) {
    @SerializedName("monday") Monday("monday"),
    @SerializedName("saturday") Saturday("saturday"),
    @SerializedName("sunday") Sunday("sunday");
}

enum class Status(val value: String) {
    @SerializedName("officially-assigned") OfficiallyAssigned("officially-assigned"),
    @SerializedName("user-assigned") UserAssigned("user-assigned");
}


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
