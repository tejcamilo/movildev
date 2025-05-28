package com.example.fisiocare.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fisiocare.Model.HistoriaClinica

@Database(entities = [HistoriaClinica::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun historiaClinicaDao(): HistoriaClinicaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "fisiocare_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
