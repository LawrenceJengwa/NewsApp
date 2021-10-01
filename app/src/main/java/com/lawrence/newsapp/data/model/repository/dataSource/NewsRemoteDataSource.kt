package com.lawrence.newsapp.data.model.repository.dataSource

import com.lawrence.newsapp.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadLines(country: String, page: Int): Response<APIResponse>
}