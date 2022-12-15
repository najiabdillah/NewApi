package com.naji.newapi.data

import android.content.SharedPreferences
import com.naji.newapi.data.local.LocalRepository
import com.naji.newapi.data.local.room.AppDao
import com.naji.newapi.data.remote.RemoteRepository

object Injection {
    fun provideRepository(preferences: SharedPreferences, dao: AppDao) = Repository.getInstance(
        RemoteRepository.getInstance(),
        LocalRepository.getInstance(preferences, dao)
    )
}