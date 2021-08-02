package com.examassistapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase



@Database(entities = [DocumentDao::class], version = 1)
//@TypeConverters(GenreConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun documentDao(): DocumentDao
}