package com.example.exam2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class CryptoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "symbol") val symbol: String,
    @ColumnInfo(name = "imageUrl") val imageUrl: String,
    @ColumnInfo(name = "currentPrice") val currentPrice: Double,
    @ColumnInfo(name = "marketCap") val marketCap: Long,
    @ColumnInfo(name = "highestValue24h") val highestValue24h: Double,
    @ColumnInfo(name = "priceChangePercentage24h") val priceChangePercentage24h: Double,
    @ColumnInfo(name = "marketCapPercentageChange24h") val marketCapPercentageChange24h: Double,
    @ColumnInfo(name = "lowestValue24h") val lowestValue24h: Double
)
