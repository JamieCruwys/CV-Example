package uk.co.jamiecruwys.cv.main

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.api.ApiService
import uk.co.jamiecruwys.cv.api.Profile
import javax.inject.Inject

class MainPresenter(val view: MainView?) {

    @Inject
    lateinit var apiService: ApiService

    init {
        App.appComponent.inject(this)
    }

    fun onResume() {
        view?.showLoading()
        apiService.getProfileJson().enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                view?.hideLoading()
                val dto = response.body()
                dto?.let {
                    view?.showContent(dto)
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