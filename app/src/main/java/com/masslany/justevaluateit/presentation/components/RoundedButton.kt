package com.masslany.justevaluateit.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.masslany.justevaluateit.presentation.ui.theme.SpaceMedium
import com.masslany.justevaluateit.presentation.ui.theme.SurfaceDarkColor

@Composable
fun RoundedButton(modifier: Modifier, text: String, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .padding(SpaceMedium)
            .height(60.dp)
            .clip(CircleShape)
            .background(color = SurfaceDarkColor, shape = RoundedCornerShape(25.dp))
            .clickable {
                onClick()
            }
    ) {
        Text(
            text = text,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = SpaceMedium, end = SpaceMedium)
        )
    }
}