package com.lawrence.newsapp.domain.usecase

import com.lawrence.newsapp.data.model.Article
import com.lawrence.newsapp.domain.repo.NewsRepository

class SaveNews(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.saveNews(article)
}