package com.example.factsapp.datasource

import com.example.factsapp.R
import com.example.factsapp.model.FactsModel

object DummyData {
    val facts = listOf(
            FactsModel(R.string.kotlin, R.drawable.kotlin_logo, R.string.kt_det),
            FactsModel(R.string.cpp, R.drawable.cpp_logo, R.string.cpp_det),
            FactsModel(R.string.python, R.drawable.python_logo, R.string.python_det),
            FactsModel(R.string.php, R.drawable.php_logo, R.string.php_det),
            FactsModel(R.string.scratch, R.drawable.scratch_logo, R.string.scratch_det),
            FactsModel(R.string.go, R.drawable.go_logo, R.string.go_det),
            FactsModel(R.string.js, R.drawable.js_logo, R.string.js_det)


    )
}