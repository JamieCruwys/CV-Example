package uk.co.jamiecruwys.cv.di

import dagger.Module
import dagger.Provides
import uk.co.jamiecruwys.cv.App
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Singleton
    @Provides
    fun provideApp(): App = app
}