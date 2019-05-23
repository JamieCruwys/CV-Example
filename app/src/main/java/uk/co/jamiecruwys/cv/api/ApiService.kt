package uk.co.jamiecruwys.cv.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("ba94d38324063f2048afa00654dd9f06/raw/4a9e4b3051e08e2e60bb49a35b9b905e4c2cfb05/profile.json")
    fun getProfileJson(): Call<Profile>
}