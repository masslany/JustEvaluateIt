package com.masslany.justevaluateit.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.masslany.justevaluateit.presentation.ui.theme.SpaceMedium
import com.masslany.justevaluateit.presentation.ui.theme.SurfaceDarkColor

@Composable
fun CircleButton(modifier: Modifier, painter: Painter, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .padding(SpaceMedium)
            .height(60.dp)
            .aspectRatio(1.0f)
            .clip(CircleShape)
            .background(color = SurfaceDarkColor, shape = CircleShape)
            .clickable {
                onClick()
            }
    ) {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.Center)
                .size(30.dp)
        )
    }
}

@Composable
fun CircleButton(modifier: Modifier, text: String, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .height(60.dp)
            .aspectRatio(1.0f)
            .clip(CircleShape)
            .background(color = SurfaceDarkColor, shape = CircleShape)
            .clickable {
                onClick()
            }
    ) {
        Text(
            text = text,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}