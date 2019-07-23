package uk.co.jamiecruwys.cv.di

import dagger.Component
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.main.ui.ProjectsAdapter
import uk.co.jamiecruwys.cv.main.ui.ProjectFragment
import uk.co.jamiecruwys.cv.main.ui.ProjectPresenter
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

    fun inject(experienceFragment: ProjectFragment)

    fun inject(experiencePresenter: ProjectPresenter)

    fun inject(experienceAdapter: ProjectsAdapter)
}