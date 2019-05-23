package uk.co.jamiecruwys.cv.di

import dagger.Component
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.main.MainActivity
import uk.co.jamiecruwys.cv.main.MainPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ApiModule::class])
interface AppComponent {

    fun inject(app: App)

    fun inject(mainActivity: MainActivity)

    fun inject(mainPresenter: MainPresenter)
}