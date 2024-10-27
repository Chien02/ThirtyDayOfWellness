package com.example.thirdtydayofwellness.data

import com.example.thirdtydayofwellness.R
import com.example.thirdtydayofwellness.model.WellnessCard

class Datasource {
    fun loadWellnessCard(): List<WellnessCard> {
        return listOf<WellnessCard>(
            WellnessCard(R.string.day1, R.string.title1, R.string.subtitle1, R.drawable.image1),
            WellnessCard(R.string.day2, R.string.title2, R.string.subtitle2, R.drawable.image2),
            WellnessCard(R.string.day3, R.string.title3, R.string.subtitle3, R.drawable.image3),
            WellnessCard(R.string.day4, R.string.title4, R.string.subtitle4, R.drawable.image4),
            WellnessCard(R.string.day5, R.string.title5, R.string.subtitle5, R.drawable.image5),
            WellnessCard(R.string.day6, R.string.title6, R.string.subtitle6, R.drawable.image6),
            WellnessCard(R.string.day7, R.string.title7, R.string.subtitle7, R.drawable.image7),
            WellnessCard(R.string.day8, R.string.title8, R.string.subtitle8, R.drawable.image8),
            WellnessCard(R.string.day9, R.string.title9, R.string.subtitle9, R.drawable.image9),
            WellnessCard(R.string.day10, R.string.title10, R.string.subtitle10, R.drawable.image10)
        )
    }
}