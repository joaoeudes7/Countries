package com.jedev.countries.api.data.sources.remote.mappers

import com.jedev.countries.api.data.sources.remote.entities.CountryJsonRes
import com.jedev.countries.api.models.CountryModel

fun CountryJsonRes.toCountryModel() = CountryModel(
    name = name.common,
    region = region.toModel(),
    population = population,
    flag = flag,
    flags = flags.toModel(),
    area = area,
    latLng = latlng,
    tld = tld,
    idd = idd?.iddGeneral,
    altSpellings = altSpellings,
    subregion = subregion,
    maps = maps.toModel(),
    fifa = fifa,
    currencies = currencies?.values.orEmpty().map { it.toModel() },
    timezones = timezones,
    capitalLatLng = capitalInfo.latlng,
    postalCode = postalCode?.format,
    translations = translations.values.map { it.toModel() },
    languages = languages?.map { it.value },
    continents = continents.map { it.toModel() },
)
