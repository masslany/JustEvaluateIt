package com.masslany.justevaluateit.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.presentation.ui.theme.RoundedCornerMedium

@Composable
fun BarcodeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val verticalGradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xffCD2EFF),
            Color(0xffA42FF6)
        )
    )
    val shape = RoundedCornerShape(RoundedCornerMedium)

    Box(
        modifier = modifier
            .background(
                brush = verticalGradientBrush,
                shape = shape
            )
            .clip(shape)
            .clickable { onClick() },
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_barcode_light),
            contentDescription = stringResource(R.string.content_description_barcode_icon),
            modifier = Modifier.align(Alignment.Center)
                .size(32.dp)
        )
    }
}