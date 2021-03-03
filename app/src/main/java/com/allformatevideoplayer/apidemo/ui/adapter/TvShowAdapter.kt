package com.allformatevideoplayer.apidemo.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.allformatevideoplayer.apidemo.databinding.TvshowLayoutBinding
import com.allformatevideoplayer.apidemo.models.TvShows
import com.allformatevideoplayer.apidemo.R
import com.allformatevideoplayer.apidemo.models.TvShow

class TvShowAdapter() : RecyclerView.Adapter<TvShowAdapter.TvShowHolder>() {


    class TvShowHolder(tvshowLayoutBinding: TvshowLayoutBinding) :
        RecyclerView.ViewHolder(tvshowLayoutBinding.root) {

        var mtvshowlayoutbinding: TvshowLayoutBinding

        init {
            this.mtvshowlayoutbinding = tvshowLayoutBinding
        }

        fun bind(tvshowobj: TvShow) {
//            mtvshowlayoutbinding.tvshowlist = tvshowobj
            mtvshowlayoutbinding.setVariable(BR.tvshowlist ,tvshowobj)
            mtvshowlayoutbinding.executePendingBindings()
        }

    }

    var list: List<TvShow> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowHolder {

        val tvshowLayoutBinding: TvshowLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.tvshow_layout, parent, false
        )

        return TvShowHolder(tvshowLayoutBinding)
    }

    override fun onBindViewHolder(holder: TvShowHolder, position: Int) {
        var tvshowlist: TvShow = list.get(position)
        Log.e("check_response_page", "*************************" + tvshowlist.imageThumbnailPath)


        holder.bind(tvshowlist)
    }

    override fun getItemCount(): Int {

        return list.size
    }

}