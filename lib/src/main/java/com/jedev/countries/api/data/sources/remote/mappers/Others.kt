package com.jedev.countries.api.data.sources.remote.mappers

import com.jedev.countries.api.data.sources.remote.entities.ContinentResJson
import com.jedev.countries.api.data.sources.remote.entities.CurrencyResJson
import com.jedev.countries.api.data.sources.remote.entities.FlagsResJson
import com.jedev.countries.api.data.sources.remote.entities.MapsResJson
import com.jedev.countries.api.data.sources.remote.entities.RegionResJson
import com.jedev.countries.api.data.sources.remote.entities.TranslationResJson
import com.jedev.countries.api.models.CurrencyModel
import com.jedev.countries.api.models.EnumContinentModel
import com.jedev.countries.api.models.EnumRegionModel
import com.jedev.countries.api.models.FlagsModel
import com.jedev.countries.api.models.MapsModel
import com.jedev.countries.api.models.TranslationModel


fun FlagsResJson.toModel() = FlagsModel(png, svg, alt)

fun TranslationResJson.toModel() = TranslationModel(official, common)

fun ContinentResJson.toModel() = EnumContinentModel.valueOf(name)

fun MapsResJson.toModel() = MapsModel(googleMaps, openStreetMaps)

fun RegionResJson.toModel() = EnumRegionModel.valueOf(name)

fun CurrencyResJson.toModel() = CurrencyModel(
    name = name,
    symbol = symbol
)