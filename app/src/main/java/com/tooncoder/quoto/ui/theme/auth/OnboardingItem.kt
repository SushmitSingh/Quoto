package com.tooncoder.quoto.ui.theme.auth

import androidx.annotation.DrawableRes
import com.tooncoder.quoto.R

data class OnboardingItem(
    val title: String,
    val description: String,
    @DrawableRes val imageRes: Int
)

val onboardingItems = listOf(
    OnboardingItem(
        title = "Welcome to Quoto",
        description = "Quoto is your go-to app for daily inspiration. Browse through a collection of quotes that will motivate and uplift you.",
        imageRes = R.drawable.ic_launcher_background
    ),
    OnboardingItem(
        title = "Discover New Quotes",
        description = "Explore a wide range of categories and discover quotes from famous authors, thinkers, and leaders.",
        imageRes = R.drawable.ic_launcher_background
    ),
    OnboardingItem(
        title = "Save and Share",
        description = "Save your favorite quotes and share them with your friends and family to spread positivity and inspiration.",
        imageRes = R.drawable.ic_launcher_background
    )
)
