package uk.co.jamiecruwys.cv.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("c1a062644f16e6419cb5e70a48ebf025/raw/cc76e208f2ffd385a4ff5853a8262e020a3d2653/profile.json")
    fun getProfileJson(): Call<Profile>
}