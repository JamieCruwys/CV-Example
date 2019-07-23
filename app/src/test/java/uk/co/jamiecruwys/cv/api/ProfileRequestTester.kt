package uk.co.jamiecruwys.cv.api

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response
import uk.co.jamiecruwys.cv.model.Profile

class ProfileRequestTester {

    private val apiService: ApiService = mock()
    private val listener: APIResponseListener = mock()
    private var profileRequest: ProfileRequest = ProfileRequest(apiService)

    fun handleResponse(response: Response<Profile>?) {
        profileRequest.handleResponse(response, listener)
    }

    fun getSuccessfulResponse(body: Profile?): Response<Profile>? = Response.success(body)

    fun getErrorResponse(): Response<Profile>? = Response.error(404, ResponseBody.create(MediaType.get("application/json"), ""))

    fun verifySuccess(profile: Profile) {
        verify(listener).onSuccess(profile)
    }

    fun verifyFailure() {
        verify(listener).onFailure()
    }
}