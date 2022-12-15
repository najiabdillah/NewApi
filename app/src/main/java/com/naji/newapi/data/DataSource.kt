package com.naji.newapi.data

import androidx.lifecycle.LiveData
import com.naji.newapi.data.model.BaseResult
import com.naji.newapi.data.model.news.Article
import com.naji.newapi.data.model.news.GetNewsResponse

interface DataSource {
    suspend fun getTopHeadlinesNews(
        apiKey: String?,
        country: String?,
        category: String?,
        sources: String?,
        q: String?
    ): BaseResult<GetNewsResponse> { throw Exception() }

    suspend fun insertData(data: List<Article>) { throw Exception() }
    suspend fun deleteByCategory(category: String) { throw Exception() }
    fun getAllDataByCategory(category: String): LiveData<List<Article>> { throw Exception() }
}