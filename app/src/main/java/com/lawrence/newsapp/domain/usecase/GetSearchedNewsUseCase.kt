package com.lawrence.newsapp.domain.usecase

import com.lawrence.newsapp.data.model.APIResponse
import com.lawrence.newsapp.data.util.Resource
import com.lawrence.newsapp.domain.repo.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery: String): Resource<APIResponse>{
        return newsRepository.getSearchedNews(searchQuery)
    }
}