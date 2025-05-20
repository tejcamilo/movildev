package com.example.movildev.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movildev.model.Factura

@Database(entities = [Factura::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun facturaDao(): FacturaDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "factura_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
