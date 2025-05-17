package com.example.movildev.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cita::class], version = 1, exportSchema = false)
abstract class CitaDatabase : RoomDatabase() {
    abstract val citaDao : CitaDao

    companion object {
        @Volatile
        private var INSTANCE: CitaDatabase? = null

        // retorna instancia de CitaDatabase, construye la db si no existe
        fun getInstance(context : Context) : CitaDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CitaDatabase::class.java,
                        "cita_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}