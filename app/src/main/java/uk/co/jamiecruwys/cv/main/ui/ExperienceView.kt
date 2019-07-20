package uk.co.jamiecruwys.cv.main.ui

import uk.co.jamiecruwys.cv.api.Experience

interface ExperienceView {

    fun showPersonalProject(title: String?, link: String?, features: String?)

    fun hidePersonalProjects()

    fun showExperience(experience: List<Experience>)

    fun hideExperience()

}