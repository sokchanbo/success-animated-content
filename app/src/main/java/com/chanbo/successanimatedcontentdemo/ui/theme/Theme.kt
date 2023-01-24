package com.chanbo.successanimatedcontentdemo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun SuccessAnimatedContentTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    /*val colors = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }*/
    /*val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colors.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }*/

    MaterialTheme(
        typography = Typography,
        content = content
    )
}