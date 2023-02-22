package com.jedev.countries.api.data.sources.remote.mappers

import com.jedev.countries.api.models.CountryJsonObject
import com.jedev.countries.api.models.CountryModel

fun CountryJsonObject.toCountryModel() = CountryModel(
    name = name,
    region = region,
    population = population,
    currencies = currencies.values.toList(),
    languages = languages.values.toList(),
    flag = flag,
    area = area,
    latlng = latlng,
    tld = tld,
    idd = idd,
    altSpellings = altSpellings,
    postalCode = postalCode
)
