package com.chanbo.successanimtedcontent.compose

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.chanbo.successanimtedcontent.R
import kotlinx.coroutines.delay

internal object SuccessAnimatedContent {
    const val DEFAULT_ITEM_SPACING = 32f
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
public fun SuccessAnimatedContent(
    content: @Composable ColumnScope.() -> Unit,
    footer: @Composable ColumnScope.() -> Unit
) {

    val configuration = LocalConfiguration.current
    val screenDensity = configuration.densityDpi / 160f
    val screenHeight = configuration.screenHeightDp * screenDensity

    val itemSpacing by remember {
        mutableStateOf(SuccessAnimatedContent.DEFAULT_ITEM_SPACING)
    }

    var contentHeaderHeight by remember {
        mutableStateOf(0f)
    }

    var tickTranslateYTargetValue by remember {
        mutableStateOf(screenHeight / 2.5f)
    }

    var contentTranslationYTargetValue by remember {
        mutableStateOf(screenHeight / 1.5f)
    }

    var contentAlphaTargetValue by remember {
        mutableStateOf(0f)
    }

    var contentScaleTargetValue by remember {
        mutableStateOf(1.1f)
    }

    val tickTranslationYAnimation by animateFloatAsState(
        targetValue = tickTranslateYTargetValue, animationSpec = tween(400)
    )

    val contentTranslationYAnimation by animateFloatAsState(
        targetValue = contentTranslationYTargetValue,
        animationSpec = tween(400)
    )

    val contentScaleAnimation by animateFloatAsState(
        targetValue = contentScaleTargetValue,
        tween(600)
    )

    val contentAlphaAnimation by animateFloatAsState(
        targetValue = contentAlphaTargetValue,
        tween(100)
    )

    val image = AnimatedImageVector.animatedVectorResource(R.drawable.avd_check)

    var atEnd by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        atEnd = true

        delay(500)
        tickTranslateYTargetValue = 0f // animate to top of the screen

        contentTranslationYTargetValue = itemSpacing
        contentAlphaTargetValue = 1f
        contentScaleTargetValue = 1f
    }

    Scaffold(backgroundColor = Color.White) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(top = 32.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned {
                        contentHeaderHeight = it.size.height.toFloat()
                    }
                    .graphicsLayer {
                        translationY = tickTranslationYAnimation
                    }
            ) {
                Image(
                    painter = rememberAnimatedVectorPainter(
                        animatedImageVector = image,
                        atEnd = atEnd
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(130.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .graphicsLayer {
                        this.translationY = contentTranslationYAnimation
                        this.alpha = contentAlphaAnimation
                        this.scaleX = contentScaleAnimation
                        this.scaleY = contentScaleAnimation
                    },
                verticalArrangement = Arrangement.spacedBy(space = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                content()
                Spacer(modifier = Modifier.weight(1f))
                footer()
                Spacer(modifier = Modifier.height(4.dp))
            }

        }
    }
}