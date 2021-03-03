package com.allformatevideoplayer.apidemo.retrofit

import com.allformatevideoplayer.apidemo.models.TvShows


import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
const val BASE_URL = "https://www.episodate.com/api/"
const val USER_URL = "most-popular"

interface ApiInterface {

    /* Workspace */
    @GET(USER_URL)
    fun apiTvShowAsync(@Query("page") page: Int): Deferred<Response<TvShows>>

}