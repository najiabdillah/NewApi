package com.naji.newapi.feature.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.naji.newapi.R
import com.naji.newapi.base.BaseActivity
import com.naji.newapi.data.model.news.Article
import com.naji.newapi.feature.originalNews.OriginalNewsActivity
import com.naji.newapi.util.obtainViewModel
import com.naji.newapi.util.setImageUrl
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class DetailActivity: BaseActivity<DetailViewModel>(), DetailActivityActionListener {

    companion object{
        const val EXTRA_ARTICLE = "EXTRA_ARTICLE"
        fun startActivity(context: Context, data: Article){
            context.startActivity(Intent(context, DetailActivity::class.java)
                .putExtra(EXTRA_ARTICLE, data))
        }
    }

    override val mLayout: Int
        get() = R.layout.activity_detail
    override val mViewModel: DetailViewModel
        get() = obtainViewModel(DetailViewModel::class.java)
    override val mToolbar: Toolbar?
        get() = toolbar
    override val mTitleToolbar: String?
        get() = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getIntentData()
        setupDataToView(mViewModel.article)
        btn_read_more.setOnClickListener { this.onClickSeeOriginal(mViewModel.article?.url?:"") }
    }

    private fun getIntentData(){
        if (intent.hasExtra(EXTRA_ARTICLE)){
            mViewModel.article = intent.getParcelableExtra(EXTRA_ARTICLE)
        }
    }

    private fun setupDataToView(data: Article?){
        tv_title_detail.text = data?.title
        tv_content_detail.text = data?.content
        iv_detail.setImageUrl(data?.urlToImage?:"")
    }

    override fun onClickSeeOriginal(url: String) {
        OriginalNewsActivity.startActivity(this, url)
    }
}
