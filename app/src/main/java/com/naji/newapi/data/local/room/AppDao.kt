package com.naji.newapi.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.naji.newapi.data.model.news.Article

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: List<Article>)

    @Query("DELETE FROM Article WHERE category = :category")
    suspend fun deleteByCategory(category: String)

    @Query("SELECT * FROM Article WHERE category = :category")
    fun getAllDataByCategory(category: String): LiveData<List<Article>>
}