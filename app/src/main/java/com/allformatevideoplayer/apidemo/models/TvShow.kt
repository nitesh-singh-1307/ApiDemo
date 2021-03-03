package com.allformatevideoplayer.apidemo.models

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName

data class TvShow(
    @SerializedName("country")
    var country: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("image_thumbnail_path")
    var imageThumbnailPath: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("network")
    var network: String,
    @SerializedName("permalink")
    var permalink: String,
    @SerializedName("start_date")
    var startDate: String,
    @SerializedName("status")
    var status: String
){
    companion object {
        @BindingAdapter("profileImage")
        @JvmStatic
        fun loadImage(view: ImageView, imageThumbnailPath: String?) {
            Glide.with(view.getContext())
                .load(imageThumbnailPath).apply(RequestOptions().circleCrop())
                .into(view)
        }
    }

}


