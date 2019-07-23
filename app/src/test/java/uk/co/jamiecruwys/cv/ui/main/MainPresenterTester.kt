package uk.co.jamiecruwys.cv.ui.main

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import uk.co.jamiecruwys.cv.api.ProfileRequest
import uk.co.jamiecruwys.cv.model.Profile
import uk.co.jamiecruwys.cv.repository.ProfileRepository
import uk.co.jamiecruwys.cv.api.APIResponseListener

class MainPresenterTester {

    private val profileRequest: ProfileRequest = mock()
    private val profileRepository: ProfileRepository = mock()
    private val view: MainView = mock()
    private val presenter: MainPresenter = MainPresenter(profileRequest, profileRepository)

    init {
        presenter.attach(view)
    }

    fun setSuccessResponse(profile: Profile): MainPresenterTester {
        doAnswer {
            (it.arguments[0] as APIResponseListener).onSuccess(profile)
            null
        }.whenever(profileRequest).requestProfile(any())
        return this
    }

    fun setErrorResponse(): MainPresenterTester {
        doAnswer {
            (it.arguments[0] as APIResponseListener).onFailure()
            null
        }.whenever(profileRequest).requestProfile(any())
        return this
    }

    fun onResume() {
        presenter.onResume()
    }

    fun verifyShowLoading() {
        verify(view).showLoading()
    }

    fun verifyHideLoading() {
        verify(view).hideLoading()
    }

    fun verifyShowContent() {
        verify(view).showContent()
    }

    fun verifyNeverShowContent() {
        verify(view, never()).showContent()
    }

    fun verifyHideContent() {
        verify(view).hideContent()
    }

    fun verifyShowError() {
        verify(view).showError()
    }

    fun verifySaveToRepository(profile: Profile) {
        verify(profileRepository).save(profile)
    }

    fun verifyNeverSaveToRepository() {
        verify(profileRepository, never()).save(any())
    }
}