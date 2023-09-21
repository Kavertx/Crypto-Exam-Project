package com.example.exam2.model

import com.squareup.moshi.Json

data class Crypto(
val id: String,
val name: String,
val symbol: String,
@Json(name = "image") val imageUrl: String,
@Json(name = "current_price") val currentPrice: Double,
@Json(name = "market_cap") val marketCap: Long,
@Json(name = "high_24h") val highestValue24h: Double,
@Json(name = "price_change_percentage_24h") val priceChangePercentage24h: Double,
@Json(name = "market_cap_change_percentage_24h") val marketCapPercentageChange24h: Double,
@Json(name = "low_24h") val lowestValue24h: Double
)
