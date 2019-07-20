package uk.co.jamiecruwys.cv.di

import dagger.Component
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.main.ui.ExperienceFragment
import uk.co.jamiecruwys.cv.main.ui.ExperiencePresenter
import uk.co.jamiecruwys.cv.main.ui.MainActivity
import uk.co.jamiecruwys.cv.main.ui.MainPresenter
import uk.co.jamiecruwys.cv.main.ui.SummaryFragment
import uk.co.jamiecruwys.cv.main.ui.SummaryPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface AppComponent {

    fun inject(app: App)

    fun inject(mainActivity: MainActivity)

    fun inject(mainPresenter: MainPresenter)

    fun inject(summaryFragment: SummaryFragment)

    fun inject(summaryPresenter: SummaryPresenter)

    fun inject(experienceFragment: ExperienceFragment)

    fun inject(experiencePresenter: ExperiencePresenter)
}