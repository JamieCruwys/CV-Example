package uk.co.jamiecruwys.cv.ui.tabs.summary

import uk.co.jamiecruwys.cv.repository.ProfileRepository
import javax.inject.Inject

class SummaryPresenter @Inject constructor(val profileRepository: ProfileRepository) {

    private lateinit var view: SummaryView

    fun attach(view: SummaryView) {
        this.view = view
    }

    fun onResume() {
        val profile = profileRepository.get()

        profile?.name?.let { name ->
            view.showName(name)
        } ?: view.hideName()

        profile?.position?.let { position ->
            view.showPosition(position)
        } ?: view.hidePosition()

        view.hideContactInfoContainer()

        profile?.phone?.let { phone ->
            view.showContactInfoContainer()
            view.showPhone(phone)
        } ?: view.hidePhone()

        profile?.email?.let { email ->
            view.showContactInfoContainer()
            view.showEmail(email)
        } ?: view.hideEmail()

        profile?.summary?.let { summary ->
            view.showSummary(summary)
        } ?: view.hideSummary()

        profile?.community?.let { community ->
            view.showCommunity(community)
        } ?: view.hideCommunity()

        profile?.education?.let {
            val education = it.filterNotNull()
            if (education.isEmpty()) {
                view.hideEducation()
            } else {
                view.showEducation(education)
            }
        } ?: view.hideEducation()
    }
}