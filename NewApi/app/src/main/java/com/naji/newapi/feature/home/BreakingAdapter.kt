package com.naji.newapi.feature.home

import android.view.View
import com.naji.newapi.R
import com.naji.newapi.base.BaseAdapter
import com.naji.newapi.data.model.news.Article
import com.naji.newapi.util.setImageUrl
import kotlinx.android.synthetic.main.item_breaking.view.*

class BreakingAdapter(private val listener: HomeActionListener): BaseAdapter<Article>(){

    override val layout: Int
        get() = R.layout.item_breaking

    override fun bind(data: Article, itemView: View, position: Int) {
        itemView.iv_item_breaking.setImageUrl(data.urlToImage?:"")
        itemView.tv_item_breaking.text = data.title
        itemView.setOnClickListener { listener.onClickItem(data) }
    }

}