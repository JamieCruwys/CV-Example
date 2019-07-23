package uk.co.jamiecruwys.cv.ui.tabs.experience

import uk.co.jamiecruwys.cv.model.Project

interface ProjectView {

    fun showProjects(projects: List<Project>)

    fun hideProjects()
}