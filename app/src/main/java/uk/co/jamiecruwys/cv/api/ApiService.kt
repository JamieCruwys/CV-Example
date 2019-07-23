package uk.co.jamiecruwys.cv.api

import retrofit2.Call
import retrofit2.http.GET
import uk.co.jamiecruwys.cv.model.Profile

interface ApiService {

    @GET("09de5456de8901497704c26d6c815498/raw/7350b955c2d05beb2d1051522d31a761d9acc3fe/profile.json")
    fun getProfileJson(): Call<Profile>
}