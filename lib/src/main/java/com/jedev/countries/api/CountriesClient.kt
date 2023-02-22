@file:Suppress("unused")

package com.jedev.countries.api

import android.app.Application
import com.jedev.countries.api.data.sources.remote.CountriesAPI
import com.jedev.countries.api.data.sources.remote.clients.HttpClient
import com.jedev.countries.api.data.sources.remote.mappers.toCountryModel
import com.jedev.countries.api.models.CountryJsonRes
import com.jedev.countries.api.models.CountryModel
import kotlin.reflect.KProperty1

typealias FilterProperty = KProperty1<CountryJsonRes, *>

class CountriesClient(application: Application) {

    private val countriesApi by lazy {
        HttpClient<CountriesAPI>(application) {
            setBaseUrl(CountriesAPI.BASE_URL_V3_1)
        }
    }

    suspend fun getAll(vararg filterProperties: FilterProperty): List<CountryModel> {
        return countriesApi.getAll(filterProperties.parseToParam()).let { countries ->
            countries.map { it.toCountryModel() }
        }
    }

    suspend fun getByName(name: String, vararg filterProperties: FilterProperty): List<CountryModel> {
        return countriesApi.getByName(name, filterProperties.parseToParam()).let { countries ->
            countries.map { it.toCountryModel() }
        }
    }

    suspend fun getByCode(code: String, vararg filterProperties: FilterProperty): List<CountryModel> {
        return countriesApi.getByCode(code, filterProperties.parseToParam()).let { countries ->
            countries.map { it.toCountryModel() }
        }
    }

    suspend fun getByCurrency(currency: String, vararg filterProperties: FilterProperty): List<CountryModel> {
        return countriesApi.getByCurrency(currency, filterProperties.parseToParam()).let { countries ->
            countries.map { it.toCountryModel() }
        }
    }

    suspend fun getByLanguage(language: String, vararg filterProperties: FilterProperty): List<CountryModel> {
        return countriesApi.getByLanguage(language, filterProperties.parseToParam()).let { countries ->
            countries.map { it.toCountryModel() }
        }
    }

    suspend fun getByCapital(capital: String, vararg filterProperties: FilterProperty): List<CountryModel> {
        return countriesApi.getByCapital(capital, filterProperties.parseToParam()).let { countries ->
            countries.map { it.toCountryModel() }
        }
    }

    suspend fun getByCallingCode(callingCode: String, vararg filterProperties: FilterProperty): List<CountryModel> {
        return countriesApi.getByCallingCode(callingCode, filterProperties.parseToParam()).let { countries ->
            countries.map { it.toCountryModel() }
        }
    }

    suspend fun getByRegion(region: String, vararg filterProperties: FilterProperty): List<CountryModel> {
        return countriesApi.getByRegion(region, filterProperties.parseToParam()).let { countries ->
            countries.map { it.toCountryModel() }
        }
    }

    suspend fun getByRegionalBloc(regionalBloc: String, vararg filterProperties: FilterProperty): List<CountryModel> {
        return countriesApi.getByRegionalBloc(regionalBloc, filterProperties.parseToParam()).let { countries ->
            countries.map { it.toCountryModel() }
        }
    }

    suspend fun getBySubregion(subregion: String, vararg filterProperties: FilterProperty): List<CountryModel> {
        return countriesApi.getBySubregion(subregion, filterProperties.parseToParam()).let { countries ->
            countries.map { it.toCountryModel() }
        }
    }

    private fun <T> Array<T>.parseToParam(): String? {
        return if (isNotEmpty()) {
            joinToString(",") { it.toString() }
        } else {
            null
        }
    }
}
