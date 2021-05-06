package com.example.factsapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class FactsModel(
    //avoid caller accidentally passing in the arguments in the wrong order
    @StringRes val nameResourceId: Int,
    @DrawableRes val logoResourceId: Int,
   @StringRes val factsResourceId: Int)
