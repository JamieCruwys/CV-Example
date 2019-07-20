package uk.co.jamiecruwys.cv

import android.app.Application
import uk.co.jamiecruwys.cv.di.ApiModule
import uk.co.jamiecruwys.cv.di.AppComponent
import uk.co.jamiecruwys.cv.di.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .apiModule(ApiModule("https://gist.githubusercontent.com/JamieCruwys/"))
            .build()

        appComponent.inject(this)
    }
}