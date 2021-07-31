package com.examassistapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

//import android

@Database(entities = [db::class], version = 1)
//@TypeConverters(GenreConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}