package com.lawrence.newsapp.domain.usecase

import com.lawrence.newsapp.data.model.Article
import com.lawrence.newsapp.domain.repo.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNews(private val newsRepository: NewsRepository) {

    fun execute(): Flow<List<Article>>{
        return newsRepository.getSavedNews()
    }
}