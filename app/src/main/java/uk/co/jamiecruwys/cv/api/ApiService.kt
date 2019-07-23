package uk.co.jamiecruwys.cv.api

import retrofit2.Call
import retrofit2.http.GET
import uk.co.jamiecruwys.cv.model.Profile

interface ApiService {

    @GET("09de5456de8901497704c26d6c815498/raw/85e578cf785a8f06321991574fd6c37979c13ae3/profile.json")
    fun getProfileJson(): Call<Profile>
}