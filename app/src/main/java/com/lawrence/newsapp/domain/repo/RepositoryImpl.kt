package com.lawrence.newsapp.domain.repo

import com.lawrence.newsapp.data.model.APIResponse
import com.lawrence.newsapp.data.model.Article
import com.lawrence.newsapp.data.model.repository.dataSource.NewsRemoteDataSource
import com.lawrence.newsapp.data.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class RepositoryImpl(private val newsRemoteDataSource: NewsRemoteDataSource): NewsRepository {
    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadLines(country, page))
    }

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse>{
        if (response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}