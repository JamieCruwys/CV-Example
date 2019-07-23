package uk.co.jamiecruwys.cv.ui.tabs.summary

import uk.co.jamiecruwys.cv.model.Course

interface SummaryView {

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

    fun showEducation(education: List<Course>)

    fun hideEducation()
}