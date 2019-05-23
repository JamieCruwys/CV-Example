package uk.co.jamiecruwys.cv.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.R
import uk.co.jamiecruwys.cv.api.Profile

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.appComponent.inject(this)
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
        Log.d("Test", "Show loading")
    }

    override fun hideLoading() {
        Log.d("Test", "Hide loading")
    }

    override fun showContent(profile: Profile) {
        Log.d("Test", "Show content: %s$profile")
        text_content.text = profile.toString()
    }

    override fun showError() {
        Log.d("Test", "Show error")
        text_content.text = "Error!"
    }
}