package com.masslany.justevaluateit.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.masslany.justevaluateit.R

@Composable
fun BarcodeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(16.dp)
    ) {
        val icon = if (MaterialTheme.colors.isLight) {
            painterResource(id = R.drawable.ic_barcode_dark)
        } else {
            painterResource(id = R.drawable.ic_barcode_light)
        }
        Image(
            painter = icon,
            contentDescription = stringResource(R.string.content_description_barcode_icon)
        )
    }
}