package com.masslany.justevaluateit.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.masslany.justevaluateit.presentation.ui.theme.*

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    showNavigationIcon: Boolean = false,
    onNavigationIconClicked: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .padding(top = AppBarTopPadding, start = SpaceMedium)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showNavigationIcon) {
            BackNavigationIcon(
                modifier = Modifier
                    .size(AppBarBackIconSize)
                    .padding(end = SpaceSmall)
                    .clip(CircleShape)
            ) {
                onNavigationIconClicked()
            }
        }

        title()
    }
}