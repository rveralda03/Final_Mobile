package com.d121211066.brewery.data.repository

import com.d121211066.brewery.data.response.GetBreweryResponse
import com.d121211066.brewery.data.source.remote.ApiService

class BreweryRepository(private val apiService: ApiService) {

    suspend fun getBrewery(by_city: String, per_page: String): GetBreweryResponse {
        return apiService.getBrewery(by_city, per_page)
    }
}