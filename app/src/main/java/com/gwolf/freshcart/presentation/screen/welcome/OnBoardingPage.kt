package com.gwolf.freshcart.presentation.screen.welcome

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.gwolf.freshcart.R

sealed class OnBoardingPage(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @DrawableRes val icon: Int = 0,
    @StringRes val description: Int
) {
    data object First : OnBoardingPage(
        image = R.drawable.onboarding_1,
        title = R.string.onboarding_title_1,
        icon = R.drawable.app_title,
        description = R.string.onboarding_desc_1
    )

    data object Second : OnBoardingPage(
        image = R.drawable.onboarding_2,
        title = R.string.onboarding_title_2,
        description = R.string.onboarding_desc_2
    )

    data object Third : OnBoardingPage(
        image = R.drawable.onboarding_3,
        title = R.string.onboarding_title_3,
        description = R.string.onboarding_desc_3
    )

    data object Fourth : OnBoardingPage(
        image = R.drawable.onboarding_4,
        title = R.string.onboarding_title_4,
        description = R.string.onboarding_desc_4
    )
}