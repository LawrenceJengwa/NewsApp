package com.lawrence.newsapp.data.model.repository.dataSourceImp

import com.lawrence.newsapp.data.api.NewsApiService
import com.lawrence.newsapp.data.model.APIResponse
import com.lawrence.newsapp.data.model.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(private val newsApiService: NewsApiService): NewsRemoteDataSource {
    override suspend fun getTopHeadLines(country: String, page: Int): Response<APIResponse> {
        return newsApiService.getTopHeadlines(country, page)
    }
}