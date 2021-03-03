package com.allformatevideoplayer.apidemo.models

import com.google.gson.annotations.SerializedName

data class TvShows(
    @SerializedName("page")
    var page: Int,
    @SerializedName("pages")
    var pages: Int,
    @SerializedName("total")
    var total: String,
    @SerializedName("tv_shows")
    var tvShows: List<TvShow>
)
