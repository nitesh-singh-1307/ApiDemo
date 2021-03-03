package com.allformatevideoplayer.apidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.allformatevideoplayer.apidemo.databinding.ActivityMainBinding
import com.allformatevideoplayer.apidemo.ui.adapter.TvShowAdapter
import com.allformatevideoplayer.apidemo.viewmodel.TVShowViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var tvShowViewModel: TVShowViewModel
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        tvShowViewModel = ViewModelProvider(this@MainActivity).get(TVShowViewModel::class.java)
        tvShowAdapter  = TvShowAdapter()
        mainBinding.recyclerView.adapter = tvShowAdapter
        observeViewModel()

    }

    private fun observeViewModel() {
        tvShowViewModel.getAllTvShow().observe(this, Observer {
            Log.e("check_response_data", "*************************" + it.tvShows.get(0).name)
            Log.e("check_response_page", "*************************" + it.page)
            Log.e("check_response_page", "*************************" + it.pages)
            tvShowAdapter?.list = it.tvShows
        })

    }
}