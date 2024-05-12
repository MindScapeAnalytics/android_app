package com.example.msanalytics.data.di

import android.content.Context
import androidx.room.Room
import com.example.msanalytics.data.local.base.TokenRoomDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            TokenRoomDataBase::class.java,
            "msanalytics_base"
        ).build()
}