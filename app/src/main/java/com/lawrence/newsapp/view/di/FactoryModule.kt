package com.lawrence.newsapp.view.di

import android.app.Application
import com.lawrence.newsapp.domain.usecase.GetNewsHeadlinesUseCase
import com.lawrence.newsapp.presantation.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(app: Application, getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase): NewsViewModelFactory{
        return NewsViewModelFactory(app, getNewsHeadlinesUseCase)
    }
}