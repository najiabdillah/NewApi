package com.naji.newapi.feature.home

import com.naji.newapi.data.model.news.Article

interface HomeActionListener {
    fun onClickItem(data: Article)
}