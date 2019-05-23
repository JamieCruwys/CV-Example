package uk.co.jamiecruwys.cv.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.R
import uk.co.jamiecruwys.cv.api.Course
import uk.co.jamiecruwys.cv.api.Experience
import uk.co.jamiecruwys.cv.api.Profile
import uk.co.jamiecruwys.cv.api.Project

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.appComponent.inject(this)
        presenter = MainPresenter(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showLoading() {
        progress_container.isVisible = true
        profile_container.isVisible = false
    }

    override fun hideLoading() {
        progress_container.isVisible = false
        profile_container.isVisible = true
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

    override fun showPersonalProjects(personalProjects: List<Project>) {
        // TODO("not implemented")
    }

    override fun hidePersonalProjects() {
        personal_projects_card.isVisible = false
    }

    override fun showEducation(education: List<Course>) {
        // TODO("not implemented")
    }

    override fun hideEducation() {
        // TODO("not implemented")
    }

    override fun showExperience(experience: List<Experience>) {
        // TODO("not implemented")
    }

    override fun hideExperience() {
        // TODO("not implemented")
    }

    override fun showError() {
        Log.d("Test", "Show error")
    }
}