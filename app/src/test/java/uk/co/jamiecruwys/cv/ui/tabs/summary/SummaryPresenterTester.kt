package uk.co.jamiecruwys.cv.ui.tabs.summary

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.anyOrNull
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import uk.co.jamiecruwys.cv.model.Course
import uk.co.jamiecruwys.cv.model.Profile
import uk.co.jamiecruwys.cv.repository.ProfileRepository

class SummaryPresenterTester {

    private val profileRepository: ProfileRepository = mock()
    private val view: SummaryView = mock()
    private val presenter: SummaryPresenter = SummaryPresenter(profileRepository)

    init {
        presenter.attach(view)
    }

    fun setProfile(profile: Profile?) {
        whenever(profileRepository.get()).thenReturn(profile)
    }

    fun onResume() {
        presenter.onResume()
    }

    fun verifyShowName(name: String) {
        verify(view).showName(name)
    }

    fun verifyNeverShowName() {
        verify(view, never()).showName(any())
    }

    fun verifyHideName() {
        verify(view).hideName()
    }

    fun verifyNeverHideName() {
        verify(view, never()).hideName()
    }

    fun verifyShowPosition(position: String) {
        verify(view).showPosition(position)
    }

    fun verifyNeverShowPosition() {
        verify(view, never()).showPosition(any())
    }

    fun verifyHidePosition() {
        verify(view).hidePosition()
    }

    fun verifyNeverHidePosition() {
        verify(view, never()).hidePosition()
    }

    fun verifyShowContactInfoContainer(times: Int = 1) {
        verify(view, times(times)).showContactInfoContainer()
    }

    fun verifyNeverShowContactInfoContainer() {
        verify(view, never()).showContactInfoContainer()
    }

    fun verifyHideContactInfoContainer() {
        verify(view).hideContactInfoContainer()
    }

    fun verifyNeverHideContactInfoContainer() {
        verify(view, never()).hideContactInfoContainer()
    }

    fun verifyShowPhone(phone: String) {
        verify(view).showPhone(phone)
    }

    fun verifyNeverShowPhone() {
        verify(view, never()).showPhone(any())
    }

    fun verifyHidePhone() {
        verify(view).hidePhone()
    }

    fun verifyNeverHidePhone() {
        verify(view, never()).hidePhone()
    }

    fun verifyShowEmail(email: String) {
        verify(view).showEmail(email)
    }

    fun verifyNeverShowEmail() {
        verify(view, never()).showEmail(any())
    }

    fun verifyHideEmail() {
        verify(view).hideEmail()
    }

    fun verifyNeverHideEmail() {
        verify(view, never()).hideEmail()
    }

    fun verifyShowSummary(summary: String) {
        verify(view).showSummary(summary)
    }

    fun verifyNeverShowSummary() {
        verify(view, never()).showSummary(any())
    }

    fun verifyHideSummary() {
        verify(view).hideSummary()
    }

    fun verifyNeverHideSummary() {
        verify(view, never()).hideSummary()
    }

    fun verifyShowCommunity(community: String) {
        verify(view).showCommunity(community)
    }

    fun verifyNeverShowCommunity() {
        verify(view, never()).showCommunity(any())
    }

    fun verifyHideCommunity() {
        verify(view).hideCommunity()
    }

    fun verifyNeverHideCommunity() {
        verify(view, never()).hideCommunity()
    }

    fun verifyShowEducation(education: List<Course>) {
        verify(view).showEducation(education)
    }

    fun verifyNeverShowEducation() {
        verify(view, never()).showEducation(any())
    }

    fun verifyHideEducation() {
        verify(view).hideEducation()
    }

    fun verifyNeverHideEducation() {
        verify(view, never()).hideEducation()
    }

    fun verifyNoMoreInteractions() {
        verifyNoMoreInteractions(view)
    }
}