package com.examassistapp.di

import com.examassistapp.data.remote.DocumentDatabase
import com.examassistapp.models.DocumentData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideMusicDatabase() = DocumentDatabase()
}