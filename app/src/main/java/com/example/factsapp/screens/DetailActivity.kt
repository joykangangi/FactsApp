package com.example.factsapp.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.factsapp.adapter.FactsAdapter
import com.example.factsapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private var binding: ActivityDetailBinding? = null
    private var logo = 0
    private var name: String? = ""
    private var detail: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        logo = intent.getIntExtra(FactsAdapter.LOGO_EXTRA, 0)
        name = intent.getStringExtra(FactsAdapter.NAME_EXTRA)
        detail = intent.getStringExtra(FactsAdapter.FACT_EXTRA)
        setUpFactDetail()
    }

    private fun setUpFactDetail() {
binding?.detailTv?.text = detail
        binding?.logoIv?.setImageResource(logo)
        title = name
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}