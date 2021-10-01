package com.lawrence.newsapp.view.di

import com.lawrence.newsapp.data.api.NewsApiService
import com.lawrence.newsapp.data.model.repository.dataSource.NewsRemoteDataSource
import com.lawrence.newsapp.data.model.repository.dataSourceImp.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun providesNewsRemoteDataSource(newsApiService: NewsApiService): NewsRemoteDataSource{
        return NewsRemoteDataSourceImpl(newsApiService)
    }
}