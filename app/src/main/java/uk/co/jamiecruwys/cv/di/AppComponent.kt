package uk.co.jamiecruwys.cv.di

import dagger.Component
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.api.ProfileRequest
import uk.co.jamiecruwys.cv.ui.tabs.experience.ProjectsAdapter
import uk.co.jamiecruwys.cv.ui.tabs.experience.ProjectFragment
import uk.co.jamiecruwys.cv.ui.tabs.experience.ProjectPresenter
import uk.co.jamiecruwys.cv.ui.main.MainActivity
import uk.co.jamiecruwys.cv.ui.main.MainPresenter
import uk.co.jamiecruwys.cv.ui.tabs.summary.SummaryFragment
import uk.co.jamiecruwys.cv.ui.tabs.summary.SummaryPresenter
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

    fun inject(profileRequest: ProfileRequest)
}