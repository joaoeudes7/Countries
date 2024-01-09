package com.jedev.countries.api.data.sources.remote.mappers

import com.jedev.countries.api.data.sources.remote.entities.CountryJsonRes
import com.jedev.countries.api.models.CountryModel

fun CountryJsonRes.toCountryModel() = CountryModel(
    name = name.common,
    region = region,
    population = population,
    flag = flag,
    area = area,
    latLng = latlng,
    tld = tld,
    idd = idd?.iddGeneral,
    altSpellings = altSpellings,
    postalCode = postalCode?.format,
    languages = languages?.map { it.value }
)
