package uk.co.jamiecruwys.cv.di

import dagger.Component
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.ui.tabs.experience.ProjectsAdapter
import uk.co.jamiecruwys.cv.ui.tabs.experience.ProjectFragment
import uk.co.jamiecruwys.cv.ui.main.MainActivity
import uk.co.jamiecruwys.cv.ui.tabs.summary.SummaryFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface AppComponent {

    fun inject(app: App)

    fun inject(mainActivity: MainActivity)

    fun inject(summaryFragment: SummaryFragment)

    fun inject(experienceFragment: ProjectFragment)

    fun inject(experienceAdapter: ProjectsAdapter)
}