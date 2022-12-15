package com.naji.newapi.data.local

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import com.naji.newapi.data.DataSource
import com.naji.newapi.data.local.room.AppDao
import com.naji.newapi.data.model.news.Article

class LocalRepository(
    private val preferences: SharedPreferences,
    private val dao: AppDao
): DataSource {

    override suspend fun insertData(data: List<Article>) { dao.insertData(data) }

    override suspend fun deleteByCategory(category: String) { dao.deleteByCategory(category) }

    override fun getAllDataByCategory(category: String): LiveData<List<Article>> {
        return dao.getAllDataByCategory(category)
    }

    companion object{
        @SuppressLint("StaticFieldLeak")
        private var INSTANCE: LocalRepository? = null
        fun getInstance(
            preferences: SharedPreferences,
            dao: AppDao
        ) = INSTANCE ?: LocalRepository(preferences, dao)
    }
}