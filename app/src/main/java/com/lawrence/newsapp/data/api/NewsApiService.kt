package com.lawrence.newsapp.data.api

import com.lawrence.newsapp.BuildConfig
import com.lawrence.newsapp.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country")
        country: String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey:String = BuildConfig.API_KEY): Response<APIResponse>

}