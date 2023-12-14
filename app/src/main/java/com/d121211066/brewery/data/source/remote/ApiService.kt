package com.d121211066.brewery.data.source.remote

import com.d121211066.brewery.data.response.GetBreweryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/breweries")
    suspend fun getBrewery(
        @Query("by_city") byCity: String,
        @Query("per_page") perPage: String,
    ): GetBreweryResponse

}