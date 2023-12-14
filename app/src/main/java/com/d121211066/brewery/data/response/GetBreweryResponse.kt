package com.d121211066.brewery.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetBreweryResponse(
    @SerialName("name")
    val name: String?,
    @SerialName("brewery_type")
    val brewery_type: String?,
    @SerialName("city")
    val city: String?,
    @SerialName("country")
    val country: String?,
    @SerialName("phone")
    val phone: String?,
    @SerialName("website_url")
    val website_url: String?,
    @SerialName("state")
    val state: String?,
    @SerialName("street")
    val street: String?
)