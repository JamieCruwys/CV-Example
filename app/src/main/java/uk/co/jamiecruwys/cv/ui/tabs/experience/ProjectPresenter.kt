package uk.co.jamiecruwys.cv.ui.tabs.experience

import uk.co.jamiecruwys.cv.repository.ProfileRepository
import javax.inject.Inject

class ProjectPresenter @Inject constructor(var profileRepository: ProfileRepository) {

    private lateinit var view: ProjectView

    fun attach(view: ProjectView) {
        this.view = view
    }

    fun onResume() {
        val projects = profileRepository.get()?.projects?.filterNotNull() ?: listOf()
        view.showProjects(projects)
    }
}