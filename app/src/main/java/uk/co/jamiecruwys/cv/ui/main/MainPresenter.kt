package uk.co.jamiecruwys.cv.ui.main

import uk.co.jamiecruwys.cv.api.APIResponseListener
import uk.co.jamiecruwys.cv.api.ProfileRequest
import uk.co.jamiecruwys.cv.model.Profile
import uk.co.jamiecruwys.cv.repository.ProfileRepository
import javax.inject.Inject

class MainPresenter @Inject constructor(
    val request: ProfileRequest,
    val repository: ProfileRepository
) {

    private lateinit var view: MainView

    fun attach(view: MainView) {
        this.view = view
    }

    fun onResume() {
        view.hideContent()
        view.showLoading()
        request.requestProfile(object : APIResponseListener {
            override fun onSuccess(profile: Profile) {
                view.hideLoading()
                repository.save(profile)
                view.showContent()
            }

            override fun onFailure() {
                view.hideLoading()
                view.showError()
            }
        })
    }
}