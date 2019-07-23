package uk.co.jamiecruwys.cv.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.model.Profile
import javax.inject.Inject

class ProfileRequest @Inject constructor(val apiService: ApiService) {

    fun requestProfile(listener: APIResponseListener) {
        apiService.getProfileJson().enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                handleResponse(response, listener)
            }

            override fun onFailure(call: Call<Profile>, t: Throwable) {
                handleResponse(null, listener)
            }
        })
    }

    fun handleResponse(response: Response<Profile>?, listener: APIResponseListener) {
        response?.body()?.let {
            listener.onSuccess(it)
        } ?: listener.onFailure()
    }
}