package com.masslany.justevaluateit.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.masslany.justevaluateit.R

@Composable
fun BackNavigationIcon(
    modifier: Modifier = Modifier,
    onNavigationIconClicked: () -> Unit = {}
) {
    val icon = if (MaterialTheme.colors.isLight) {
        painterResource(id = R.drawable.ic_back_arrow_dark)
    } else {
        painterResource(id = R.drawable.ic_back_arrow_light)
    }

    Image(
        painter = icon,
        contentDescription = "",
        modifier = modifier
            .clickable {
                onNavigationIconClicked()
            }
    )
}