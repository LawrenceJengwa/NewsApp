package com.lawrence.newsapp.domain.usecase

import com.lawrence.newsapp.data.model.APIResponse
import com.lawrence.newsapp.data.util.Resource
import com.lawrence.newsapp.domain.repo.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, page: Int): Resource<APIResponse>{
        return newsRepository.getNewsHeadlines(country, page)
    }

}