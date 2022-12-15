package com.naji.newapi.feature.splash

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.widget.Toolbar
import com.naji.newapi.R
import com.naji.newapi.base.BaseActivity
import com.naji.newapi.feature.home.HomeActivity
import com.naji.newapi.util.obtainViewModel

class SplashActivity: BaseActivity<SplashViewModel>() {
    override val mLayout: Int
        get() = R.layout.activity_splash
    override val mViewModel: SplashViewModel
        get() = obtainViewModel(SplashViewModel::class.java)
    override val mToolbar: Toolbar?
        get() = null
    override val mTitleToolbar: String?
        get() = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        openActivity()
    }

    private fun openActivity(){
        val handler = Handler()
        handler.postDelayed({
            HomeActivity.startActivity(this)
            finish()
        }, 3000)
    }
}
