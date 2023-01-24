package com.chanbo.successanimatedcontentdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chanbo.successanimatedcontentdemo.ui.theme.SuccessAnimatedContentTheme
import com.chanbo.successanimtedcontent.compose.SuccessAnimatedContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuccessAnimatedContentTheme {
                SuccessAnimatedContent(
                    content = {
                        Text(
                            text = "Upload profile successfully",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.Center
                        )
                    },
                    footer = {
                        Button(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                            contentPadding = PaddingValues(16.dp),
                            shape = CircleShape,
                            elevation = ButtonDefaults.elevation(
                                defaultElevation = 0.dp,
                                pressedElevation = 0.dp,
                                hoveredElevation = 0.dp,
                                focusedElevation = 0.dp
                            )
                        ) {
                            Text(text = "Done")
                        }
                    }
                )
            }
        }
    }
}
