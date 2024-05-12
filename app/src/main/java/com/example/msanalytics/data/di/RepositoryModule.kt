package com.example.msanalytics.data.di

import com.example.msanalytics.data.repository.AccountRepository
import com.example.msanalytics.data.repository.QuestionRepository
import com.example.msanalytics.data.api.retrofit.backend.BackendApiService
import com.example.msanalytics.data.api.retrofit.backend.BackendExternalDataSource
import com.example.msanalytics.data.api.retrofit.backend.BackendRetrofitDataSource
import com.example.msanalytics.data.local.base.TokenRoomDataBase
import com.example.msanalytics.data.local.token.RoomTokenLocalDataSource
import com.example.msanalytics.data.local.token.TokenLocalDataSource
import com.example.msanalytics.data.local.token.dao.TokenDao
import com.example.msanalytics.data.repository.EventRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideTokenLocalDataSource(
        tokenRoomDataBase: TokenRoomDataBase
    ): TokenLocalDataSource =
        RoomTokenLocalDataSource(tokenRoomDataBase.tokenDao())

    @Singleton
    @Provides
    fun provideAccountRepository(
        backendExternalDataSource: BackendExternalDataSource,
        tokenLocalDataSource: TokenLocalDataSource
    ): AccountRepository =
        AccountRepository(backendExternalDataSource, tokenLocalDataSource)

    @Singleton
    @Provides
    fun provideEventRepository(
        backendExternalDataSource: BackendExternalDataSource,
    ): EventRepository =
        EventRepository(backendExternalDataSource)

    @Singleton
    @Provides
    fun provideTestingRepository(
        backendExternalDataSource: BackendExternalDataSource
    ): QuestionRepository =
        QuestionRepository(backendExternalDataSource)

    @Singleton
    @Provides
    fun provideBackendExternalDataSource(
        apiService: BackendApiService
    ): BackendExternalDataSource =
        BackendRetrofitDataSource(apiService)
}