package com.masslany.justevaluateit.ui.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.masslany.justevaluateit.ui.theme.ButtonColor
import com.masslany.justevaluateit.ui.theme.SpaceMedium

@Composable
fun DashboardTile(
    modifier: Modifier = Modifier,
    text: String,
    icon: Painter,
    contentDescription: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .background(
                color = ButtonColor,
                shape = RoundedCornerShape(24.dp)
            )
            .clip(RoundedCornerShape(24.dp))
            .clickable {
                onClick()
            }
            .aspectRatio(1f)
    ) {
        Image(
            painter = icon,
            contentDescription = contentDescription,
            modifier = Modifier
                .align(Alignment.Center)
                .size(64.dp)
        )
        Text(
            text = text,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = SpaceMedium)
        )
    }
}