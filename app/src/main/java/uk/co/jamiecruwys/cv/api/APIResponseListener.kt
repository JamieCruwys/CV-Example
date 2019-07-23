package uk.co.jamiecruwys.cv.api

import uk.co.jamiecruwys.cv.model.Profile

interface APIResponseListener {
    fun onSuccess(profile: Profile)
    fun onFailure()
}