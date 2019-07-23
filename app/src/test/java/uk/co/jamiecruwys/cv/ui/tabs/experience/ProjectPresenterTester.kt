package uk.co.jamiecruwys.cv.ui.tabs.experience

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import uk.co.jamiecruwys.cv.model.Profile
import uk.co.jamiecruwys.cv.model.Project
import uk.co.jamiecruwys.cv.repository.ProfileRepository

class ProjectPresenterTester {

    private val profileRepository: ProfileRepository = mock()
    private val view: ProjectView = mock()
    private val presenter: ProjectPresenter = ProjectPresenter(profileRepository)

    init {
        presenter.attach(view)
    }

    fun setProfile(profile: Profile?) {
        whenever(profileRepository.get()).thenReturn(profile)
    }

    fun onResume() {
        presenter.onResume()
    }

    fun verifyShowProjects(projects: List<Project>) {
        verify(view).showProjects(projects)
    }
}