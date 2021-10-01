package com.lawrence.newsapp.data

import com.google.common.truth.ExpectFailure.assertThat
import com.lawrence.newsapp.data.api.NewsApiService
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertFalse
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApiServiceTest {
    private lateinit var service: NewsApiService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)

    }


    private fun enqueueMockResponse(fileName: String){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadlines_sentRequest_receivedExpected(){
        runBlocking {
            enqueueMockResponse("newsResponse.json")
            val responseBody = service.getTopHeadlines("US", 1).body()
            val request = server.takeRequest()
            //assertThat(responseBody).isNotNull()
            //assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=841cb5867549480bbec2530bbec12441")
        }
    }

    @Test
    fun getTopHeadlines_ReceivedResponse_correctPageSize(){
        runBlocking {
            enqueueMockResponse("newsResponse.json")
            val responseBody = service.getTopHeadlines("US", 1).body()
            val articlesList = responseBody!!.articles
            //assertThat(articlesList.size).isEqualTo(20)
            assertEquals(20, articlesList.size)
            assertFalse(true)
        }
    }

    @Test
    fun getTopHeadlines_ReceivedResponse_correctContnt(){
        runBlocking {
            enqueueMockResponse("newsResponse.json")
            val responseBody = service.getTopHeadlines("US", 1).body()
            val articlesList = responseBody!!.articles
            val article = articlesList[0]
            assertEquals(article.author, "Saheli Roy Choudhury")
            //assertThat(article.author).isEqualTo()

        }
    }

    @After
    fun tearDown(){
        server.shutdown()

    }

}