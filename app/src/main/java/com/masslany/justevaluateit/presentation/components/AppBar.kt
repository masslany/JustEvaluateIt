package com.masslany.justevaluateit.presentation.components

import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    navigationIcon: @Composable (() -> Unit)? = null,
) {
    TopAppBar(
        title = title,
        navigationIcon = navigationIcon,
        modifier = modifier,
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    )
}