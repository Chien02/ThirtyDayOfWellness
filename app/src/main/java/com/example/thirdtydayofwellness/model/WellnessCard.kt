package com.example.thirdtydayofwellness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class WellnessCard (
    @StringRes val dayResourceId: Int,
    @StringRes val titleResourceId : Int,
    @StringRes val subtitleResourceId : Int,
    @DrawableRes val imageResourceId : Int
)