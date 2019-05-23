package uk.co.jamiecruwys.cv.main

import uk.co.jamiecruwys.cv.api.Course
import uk.co.jamiecruwys.cv.api.Experience

interface MainView {

    fun showLoading()

    fun hideLoading()

    fun showError()

    fun showName(name: String)

    fun hideName()

    fun showPosition(position: String)

    fun hidePosition()

    fun showContactInfoContainer()

    fun hideContactInfoContainer()

    fun showPhone(phone: String)

    fun hidePhone()

    fun showEmail(email: String)

    fun hideEmail()

    fun showSummary(summary: String)

    fun hideSummary()

    fun showCommunity(community: String)

    fun hideCommunity()

    fun showPersonalProject(title: String?, link: String?, features: String?)

    fun hidePersonalProjects()

    fun showEducation(education: List<Course>)

    fun hideEducation()

    fun showExperience(experience: List<Experience>)

    fun hideExperience()
}