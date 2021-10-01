package com.lawrence.newsapp.view.di

import com.lawrence.newsapp.data.model.repository.dataSource.NewsRemoteDataSource
import com.lawrence.newsapp.domain.repo.NewsRepository
import com.lawrence.newsapp.domain.repo.RepositoryImpl
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
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository {
        return RepositoryImpl(newsRemoteDataSource)
    }
}