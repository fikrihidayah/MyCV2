package com.filkom.mycv2.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun Mycv2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) darkColorScheme() else lightColorScheme()

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}