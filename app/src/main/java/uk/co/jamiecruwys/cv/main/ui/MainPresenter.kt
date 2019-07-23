package uk.co.jamiecruwys.cv.main.ui

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.api.ApiService
import uk.co.jamiecruwys.cv.api.Profile
import uk.co.jamiecruwys.cv.main.ProfileRepository
import javax.inject.Inject

class MainPresenter(val view: MainView?) {

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var cvRepository: ProfileRepository

    init {
        App.appComponent.inject(this)
    }

    fun onResume() {
        view?.hideContent()
        view?.showLoading()

        apiService.getProfileJson().enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                view?.hideLoading()
                response.body()?.let { dto ->
                    cvRepository.save(dto)
                    view?.showContent()
                } ?: view?.showError()
            }

            override fun onFailure(call: Call<Profile>, t: Throwable) {
                view?.hideLoading()
                view?.showError()
            }
        })
    }

    fun onDestroy() {
    }
}