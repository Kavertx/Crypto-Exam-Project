package com.example.exam2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.exam2.model.Crypto

@Database(entities = [CryptoEntity::class], version = 1, exportSchema = false)
abstract class CryptoRoomDatabase : RoomDatabase() {

    abstract fun cryptoDao(): CryptoDao

    companion object {
        @Volatile
        private var INSTANCE: CryptoRoomDatabase? = null

        fun getDatabase(context: Context): CryptoRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CryptoRoomDatabase::class.java,
                    "crypto_database"
                )

                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}