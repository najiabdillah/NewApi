package com.naji.newapi.feature.detail

import androidx.lifecycle.ViewModel
import com.naji.newapi.data.Repository
import com.naji.newapi.data.model.news.Article

class DetailViewModel(private val repository: Repository): ViewModel(){
    var article: Article? = null
}