@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package com.jedev.countries.api.data.sources.remote.clients

import android.app.Application
import com.google.gson.GsonBuilder
import com.jedev.countries.api.extensions.alsoIf
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


class HttpClient(
    private val application: Application
) {

    companion object {
        inline operator fun <reified T : Any> invoke(
            application: Application,
            block: HttpClient.() -> Unit
        ) = HttpClient(application).apply(block).build<T>()
    }

    private val internalClient = OkHttpClient().newBuilder()
    private val internalMap = Retrofit.Builder()

    var enabledCache = true
    var enabledLogging = true

    fun setBaseUrl(url: String) {
        internalMap.baseUrl(url)
    }

    fun addConverterFactory(converterFactory: Converter.Factory) {
        internalMap.addConverterFactory(converterFactory)
    }

    fun putInterceptors(vararg interceptor: okhttp3.Interceptor) {
        interceptor.forEach {
            internalClient.addInterceptor(it)
        }
    }

    fun <T> build(serviceClass: Class<T>): T {
        val okHttpClient = internalClient
            .alsoIf(enabledCache) {
                val cacheSize = 10 * 1024 * 1024L // 10 MiB
                val cacheDir = File(application.cacheDir, "http_cache")
                val cache = Cache(cacheDir, cacheSize)

                it.cache(cache)
            }
            .alsoIf(enabledLogging) {
                val logging = HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.HEADERS
                }

                it.addInterceptor(logging)
            }

        if (internalMap.converterFactories().isEmpty()) {
            val gson = GsonBuilder().setLenient().serializeNulls().create()
            val converterFactory = GsonConverterFactory.create(gson)

            addConverterFactory(converterFactory)
        }

        return internalMap
            .client(okHttpClient.build())
            .build()
            .create(serviceClass)
    }

    inline fun <reified T> build(): T {
        return build(T::class.java)
    }
}



