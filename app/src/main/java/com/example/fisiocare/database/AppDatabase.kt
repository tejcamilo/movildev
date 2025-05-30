package com.example.fisiocare.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fisiocare.database.dao.HistoriaClinicaDao
import com.example.fisiocare.Model.HistoriaClinica

@Database(entities = [HistoriaClinica::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historiaClinicaDao(): HistoriaClinicaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
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
