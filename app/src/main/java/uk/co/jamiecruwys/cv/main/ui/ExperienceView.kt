package uk.co.jamiecruwys.cv.main.ui

import uk.co.jamiecruwys.cv.api.Experience

interface ExperienceView {

    fun showExperience(experience: List<Experience>)

    fun hideExperience()
}