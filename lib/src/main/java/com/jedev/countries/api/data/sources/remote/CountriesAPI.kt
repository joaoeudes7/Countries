package com.jedev.countries.api.data.sources.remote

import com.jedev.countries.api.models.CountryJsonObject
import retrofit2.http.GET
import retrofit2.http.Path


interface CountriesAPI {
    companion object {
        private const val BASE_URL = "https://restcountries.com"
        const val BASE_URL_V3_1 = "$BASE_URL/v3.1/"
    }

    @GET("all")
    suspend fun getAll(
        @Path("filters") filters: String?
    ): List<CountryJsonObject>

    @GET("name/{name}")
    suspend fun getByName(
        @Path("name") name: String,
        @Path("filters") filters: String?
    ): List<CountryJsonObject>

    @GET("alpha/{code}")
    suspend fun getByCode(
        @Path("code") code: String,
        @Path("filters") filters: String?
    ): List<CountryJsonObject>

    @GET("currency/{currency}")
    suspend fun getByCurrency(
        @Path("currency") currency: String,
        @Path("filters") filters: String?
    ): List<CountryJsonObject>

    @GET("lang/{language}")
    suspend fun getByLanguage(
        @Path("language") language: String,
        @Path("filters") filters: String?
    ): List<CountryJsonObject>

    @GET("capital/{capital}")
    suspend fun getByCapital(
        @Path("capital") capital: String,
        @Path("filters") filters: String?
    ): List<CountryJsonObject>

    @GET("callingcode/{callingCode}")
    suspend fun getByCallingCode(
        @Path("callingCode") callingCode: String,
        @Path("filters") filters: String?
    ): List<CountryJsonObject>

    @GET("region/{region}")
    suspend fun getByRegion(
        @Path("region") region: String,
        @Path("filters") filters: String?
    ): List<CountryJsonObject>

    @GET("subregion/{subregion}")
    suspend fun getBySubregion(
        @Path("subregion") subregion: String,
        @Path("filters") filters: String?
    ): List<CountryJsonObject>

    @GET("regionalbloc/{regionalBloc}")
    suspend fun getByRegionalBloc(
        @Path("regionalBloc") regionalBloc: String,
        @Path("filters") filters: String?
    ): List<CountryJsonObject>

}
