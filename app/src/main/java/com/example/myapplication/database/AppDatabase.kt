package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.dao.FileDao
import com.example.myapplication.data.CourseFile

@Database(entities = [CourseFile::class], version = 1,
    exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun fileDao(): FileDao
    companion object {
        private const val DB_NAME = "ticketing_database.db"
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DB_NAME
        ).allowMainThreadQueries().build()


    }

}