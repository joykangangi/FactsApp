package com.example.factsapp.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.factsapp.adapter.FactsAdapter
import com.example.factsapp.databinding.ActivityMainBinding
import com.example.factsapp.datasource.DummyData

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var adapter: FactsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUpFacts()
        // To show back button in actionbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun setUpFacts() {
        adapter = FactsAdapter(this, DummyData.facts)
        binding?.factsListView?.adapter = adapter
    }

    //binding = null when activity is destroyed
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}


