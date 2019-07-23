package uk.co.jamiecruwys.cv.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.R

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.appComponent.inject(this)

        view_pager.adapter = ViewPagerAdapter(this, supportFragmentManager)
        tabs.setupWithViewPager(view_pager)

        presenter = MainPresenter(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showLoading() {
        progress_container.isVisible = true
    }

    override fun hideLoading() {
        progress_container.isVisible = false
    }

    override fun showContent() {
        view_pager.isVisible = true
    }

    override fun hideContent() {
        view_pager.isVisible = false
    }

    override fun showError() {
        Log.d(MainActivity::class.java.simpleName, "Error!")
    }
}