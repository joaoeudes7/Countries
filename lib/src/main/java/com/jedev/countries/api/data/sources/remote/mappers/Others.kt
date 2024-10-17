package com.jedev.countries.api.data.sources.remote.mappers

import com.jedev.countries.api.data.sources.remote.entities.ContinentResJson
import com.jedev.countries.api.data.sources.remote.entities.CurrencyResJson
import com.jedev.countries.api.data.sources.remote.entities.FlagsResJson
import com.jedev.countries.api.data.sources.remote.entities.MapsResJson
import com.jedev.countries.api.data.sources.remote.entities.RegionResJson
import com.jedev.countries.api.data.sources.remote.entities.TranslationResJson
import com.jedev.countries.api.models.Currency
import com.jedev.countries.api.models.EnumContinent
import com.jedev.countries.api.models.EnumRegionModel
import com.jedev.countries.api.models.Flags
import com.jedev.countries.api.models.Maps
import com.jedev.countries.api.models.Translation


fun FlagsResJson.toModel() = Flags(png, svg, alt)

fun TranslationResJson.toModel() = Translation(official, common)

fun ContinentResJson.toModel() = EnumContinent.valueOf(name)

fun MapsResJson.toModel() = Maps(googleMaps, openStreetMaps)

fun RegionResJson.toModel() = EnumRegionModel.valueOf(name)

fun CurrencyResJson.toModel() = Currency(
    name = name,
    symbol = symbol
)