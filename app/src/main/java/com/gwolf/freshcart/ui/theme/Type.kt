package com.gwolf.freshcart.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.gwolf.freshcart.R

private val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)


private val roboto = GoogleFont("roboto")

val robotoFontFamily = FontFamily(
    Font(googleFont = roboto, fontProvider = provider, weight = FontWeight.ExtraBold),
    Font(googleFont = roboto, fontProvider = provider, weight = FontWeight.Bold),
    Font(googleFont = roboto, fontProvider = provider, weight = FontWeight.SemiBold),
    Font(googleFont = roboto, fontProvider = provider, weight = FontWeight.Medium),
    Font(googleFont = roboto, fontProvider = provider, weight = FontWeight.Normal),
    Font(googleFont = roboto, fontProvider = provider, weight = FontWeight.Light),
    Font(googleFont = roboto, fontProvider = provider, weight = FontWeight.ExtraLight)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)