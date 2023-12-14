package com.d121211066.brewery.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.d121211066.brewery.data.repository.BreweryRepository
import com.d121211066.brewery.data.source.remote.ApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val breweryRepository: BreweryRepository
}

class DefaultAppContainer: AppContainer {

    private val BASE_URL = "https://api.openbrewerydb.org"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val breweryRepository: BreweryRepository
        get() = BreweryRepository(retrofitService)

}