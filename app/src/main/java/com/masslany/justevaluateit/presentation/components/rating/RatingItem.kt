package com.masslany.justevaluateit.presentation.addproduct

import androidx.annotation.FloatRange
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masslany.justevaluateit.presentation.ui.theme.PurpleGradientBrush
import com.masslany.justevaluateit.presentation.ui.theme.SurfaceDarkColor


@Composable
fun RatingItem(
    @FloatRange(from = 0.0, to = 1.0) fraction: Float,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        EmptyRatingItem()
        FilledRatingItem(fraction)
    }
}

@Composable
private fun FilledRatingItem(fraction: Float) {
    Box(
        modifier = Modifier
            .background(brush = PurpleGradientBrush, shape = CircleShape)
            .clip(CircleShape)
            .fillMaxSize(fraction)
    )
}

@Composable
private fun EmptyRatingItem() {
    Box(
        modifier = Modifier
            .background(color = SurfaceDarkColor, shape = CircleShape)
            .clip(CircleShape)
            .fillMaxSize()
    )
}

@Preview(showBackground = true)
@Composable
fun EmptyRatingStarPreview() {
    RatingItem(
        fraction = 0f, modifier = Modifier.size(20.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PartialRatingStarPreview() {
    RatingItem(
        fraction = 0.7f, modifier = Modifier.size(20.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun FullRatingStarPreview() {
    RatingItem(
        fraction = 1f, modifier = Modifier.size(20.dp)
    )
}