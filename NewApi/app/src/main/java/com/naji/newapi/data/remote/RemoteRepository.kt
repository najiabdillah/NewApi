package com.naji.newapi.data.remote

import com.naji.newapi.base.BaseDataSource
import com.naji.newapi.data.DataSource
import com.naji.newapi.data.model.BaseResult
import com.naji.newapi.data.model.news.GetNewsResponse

class RemoteRepository: DataSource, BaseDataSource() {

    override suspend fun getTopHeadlinesNews(
        apiKey: String?,
        country: String?,
        category: String?,
        sources: String?,
        q: String?
    ): BaseResult<GetNewsResponse> {
        return getResult {
            ApiService.getApiService.getTopHeadlinesNews(
                apiKey,
                country,
                category,
                sources,
                q
            )
        }
    }

    companion object{
        private var INSTANCE: RemoteRepository? = null
        fun getInstance() = INSTANCE ?: RemoteRepository()
    }
}