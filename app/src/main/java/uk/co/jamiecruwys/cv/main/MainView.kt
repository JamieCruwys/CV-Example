package uk.co.jamiecruwys.cv.main

import uk.co.jamiecruwys.cv.api.Course
import uk.co.jamiecruwys.cv.api.Experience
import uk.co.jamiecruwys.cv.api.Project

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

    fun showPersonalProjects(personalProjects: List<Project>)

    fun hidePersonalProjects()

    fun showEducation(education: List<Course>)

    fun hideEducation()

    fun showExperience(experience: List<Experience>)

    fun hideExperience()

}