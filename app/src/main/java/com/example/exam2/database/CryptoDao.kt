package com.example.exam2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CryptoDao{
    @Insert
    suspend fun insert(crypto: List<CryptoEntity>)
    @Query("SELECT * FROM CryptoEntity")
    fun getAll(): Flow<List<CryptoEntity>>
}