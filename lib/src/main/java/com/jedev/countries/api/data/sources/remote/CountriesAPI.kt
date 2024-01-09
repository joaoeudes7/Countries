package com.jedev.countries.api.data.sources.remote

import com.jedev.countries.api.data.sources.remote.entities.CountriesJsonRes
import retrofit2.http.GET
import retrofit2.http.Query


interface CountriesAPI {
    companion object {
        private const val BASE_URL = "https://restcountries.com"
        const val BASE_URL_V3_1 = "$BASE_URL/v3.1/"
    }

    @GET("all")
    suspend fun getAll(
        @Query("filters") filters: String?
    ): CountriesJsonRes

    @GET("name/{name}")
    suspend fun getByName(
        @Query("name") name: String,
        @Query("filters") filters: String?
    ): CountriesJsonRes

    @GET("alpha/{code}")
    suspend fun getByCode(
        @Query("code") code: String,
        @Query("filters") filters: String?
    ): CountriesJsonRes

    @GET("currency/{currency}")
    suspend fun getByCurrency(
        @Query("currency") currency: String,
        @Query("filters") filters: String?
    ): CountriesJsonRes

    @GET("lang/{language}")
    suspend fun getByLanguage(
        @Query("language") language: String,
        @Query("filters") filters: String?
    ): CountriesJsonRes

    @GET("capital/{capital}")
    suspend fun getByCapital(
        @Query("capital") capital: String,
        @Query("filters") filters: String?
    ): CountriesJsonRes

    @GET("callingcode/{callingCode}")
    suspend fun getByCallingCode(
        @Query("callingCode") callingCode: String,
        @Query("filters") filters: String?
    ): CountriesJsonRes

    @GET("region/{region}")
    suspend fun getByRegion(
        @Query("region") region: String,
        @Query("filters") filters: String?
    ): CountriesJsonRes

    @GET("subregion/{subregion}")
    suspend fun getBySubregion(
        @Query("subregion") subregion: String,
        @Query("filters") filters: String?
    ): CountriesJsonRes

    @GET("regionalbloc/{regionalBloc}")
    suspend fun getByRegionalBloc(
        @Query("regionalBloc") regionalBloc: String,
        @Query("filters") filters: String?
    ): CountriesJsonRes

}
