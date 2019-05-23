package uk.co.jamiecruwys.cv.main

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.api.ApiService
import uk.co.jamiecruwys.cv.api.CVDto
import javax.inject.Inject

class MainPresenter(val view: MainView?) {

    @Inject
    lateinit var apiService: ApiService

    init {
        App.appComponent.inject(this)
    }

    fun onResume() {
        view?.showLoading()
        apiService.getCVJson().enqueue(object: Callback<CVDto> {
            override fun onResponse(call: Call<CVDto>, response: Response<CVDto>) {
                view?.hideLoading()
                val dto = response.body()
                dto?.let {
                    view?.showContent(dto)
                } ?: view?.showError()
            }

            override fun onFailure(call: Call<CVDto>, t: Throwable) {
                view?.hideLoading()
                view?.showError()
            }
        })
    }

    fun onDestroy() {

    }
}