package uk.co.jamiecruwys.cv.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("ba94d38324063f2048afa00654dd9f06/raw/631cf3d2a771636801dd7678b96bd3874aac2f9c/cv.json")
    fun getCVJson(): Call<Profile>
}