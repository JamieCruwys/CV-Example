package uk.co.jamiecruwys.cv.ui.tabs.summary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_summary.*
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.R
import uk.co.jamiecruwys.cv.model.Course
import javax.inject.Inject

class SummaryFragment : Fragment(), SummaryView {

    @Inject
    lateinit var presenter: SummaryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
        presenter.attach(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && isVisible && isResumed) {
            presenter.onResume()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun showName(name: String) {
        header_name.isVisible = true
        header_name.text = name
    }

    override fun hideName() {
        header_name.isVisible = false
    }

    override fun showPosition(position: String) {
        header_position.isVisible = true
        header_position.text = position
    }

    override fun hidePosition() {
        header_position.isVisible = false
    }

    override fun showContactInfoContainer() {
        contact_info_card.isVisible = true
    }

    override fun hideContactInfoContainer() {
        contact_info_card.isVisible = false
    }

    override fun showPhone(phone: String) {
        contact_info_phone_container.isVisible = true
        contact_info_phone.text = phone
    }

    override fun hidePhone() {
        contact_info_phone_container.isVisible = false
    }

    override fun showEmail(email: String) {
        contact_info_email_container.isVisible = true
        contact_info_email.text = email
    }

    override fun hideEmail() {
        contact_info_email_container.isVisible = false
    }

    override fun showSummary(summary: String) {
        summary_card.isVisible = true
        summary_text.text = summary
    }

    override fun hideSummary() {
        summary_card.isVisible = false
    }

    override fun showCommunity(community: String) {
        community_card.isVisible = true
        community_text.text = community
    }

    override fun hideCommunity() {
        community_card.isVisible = false
    }

    override fun showEducation(education: List<Course>) {
        // TODO:
    }

    override fun hideEducation() {
        // TODO:
    }

    companion object {
        @JvmStatic
        fun newInstance(): SummaryFragment = SummaryFragment()
    }
}