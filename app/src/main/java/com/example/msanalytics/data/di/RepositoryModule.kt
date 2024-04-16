package com.example.msanalytics.data.di

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
    fun providePostRepository(
        /*cheapSharkExternalDataSource: CheapSharkExternalDataSource,*/
        postLocalDataSource: PostLocalDataSource
    ): PostRepository =
        PostRepository(postLocalDataSource)

    @Singleton
    @Provides
    fun provideSearchRepository(
        rawgExternalDataSource: RawgExternalDataSource
    ): SearchRepository =
        SearchRepository(rawgExternalDataSource)

    @Singleton
    @Provides
    fun provideCheapSharkExternalDataSource(
        apiService: CheapSharkApiService
    ): CheapSharkExternalDataSource =
        CheapSharkRetrofitDataSource(apiService)

    @Singleton
    @Provides
    fun provideRawgExternalDataSource(
        apiService: RawgApiService
    ): RawgExternalDataSource =
        RawgRetrofitDataSource(apiService)
}