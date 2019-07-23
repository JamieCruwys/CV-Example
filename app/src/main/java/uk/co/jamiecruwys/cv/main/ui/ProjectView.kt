package uk.co.jamiecruwys.cv.main.ui

import uk.co.jamiecruwys.cv.model.Project

interface ProjectView {

    fun showProjects(projects: List<Project?>?)

    fun hideProjects()
}