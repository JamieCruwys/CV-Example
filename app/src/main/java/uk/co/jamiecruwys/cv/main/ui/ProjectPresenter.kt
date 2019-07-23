package uk.co.jamiecruwys.cv.main.ui

import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.main.CVRepository
import javax.inject.Inject

class ProjectPresenter(private val view: ProjectView) {

    @Inject
    lateinit var cvRepository: CVRepository

    init {
        App.appComponent.inject(this)
    }

    fun onResume() {
        val projects = cvRepository.get()?.projects
        view.showProjects(projects)
    }

    fun onDestroy() {
    }
}