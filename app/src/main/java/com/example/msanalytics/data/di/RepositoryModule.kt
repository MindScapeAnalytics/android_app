package com.example.msanalytics.data.di

import com.example.msanalytics.data.api.repository.AccountRepository
import com.example.msanalytics.data.api.retrofit.backend.BackendApiService
import com.example.msanalytics.data.api.retrofit.backend.BackendExternalDataSource
import com.example.msanalytics.data.api.retrofit.backend.BackendRetrofitDataSource
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
    fun provideAccountRepository(
        backendExternalDataSource: BackendExternalDataSource
    ): AccountRepository =
        AccountRepository(backendExternalDataSource)

    @Singleton
    @Provides
    fun provideBackendExternalDataSource(
        apiService: BackendApiService
    ): BackendExternalDataSource =
        BackendRetrofitDataSource(apiService)
}