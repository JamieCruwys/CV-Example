package uk.co.jamiecruwys.cv.main.ui

import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.repository.ProfileRepository
import javax.inject.Inject

class SummaryPresenter(private val view: SummaryView) {

    @Inject
    lateinit var cvRepository: ProfileRepository

    init {
        App.appComponent.inject(this)
    }

    fun onResume() {
        cvRepository.get()?.let { profile ->

            profile.name?.let { name ->
                view.showName(name)
            } ?: view.hideName()

            profile.position?.let { position ->
                view.showPosition(position)
            } ?: view.hidePosition()

            view.hideContactInfoContainer()

            profile.phone?.let { phone ->
                view.showContactInfoContainer()
                view.showPhone(phone)
            }

            profile.email?.let { email ->
                view.showContactInfoContainer()
                view.showEmail(email)
            }

            profile.summary?.let { summary ->
                view.showSummary(summary)
            } ?: view.hideSummary()

            profile.community?.let { community ->
                view.showCommunity(community)
            } ?: view.hideCommunity()

            profile.education?.filterNotNull().let { education ->
                if (education.isNullOrEmpty()) {
                    view.hideEducation()
                } else {
                    view.showEducation(education)
                }
            }
        }
    }

    fun onDestroy() {
    }
}