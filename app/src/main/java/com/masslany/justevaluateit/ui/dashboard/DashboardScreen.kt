package com.masslany.justevaluateit.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.ui.components.AppBar
import com.masslany.justevaluateit.ui.components.BarcodeButton
import com.masslany.justevaluateit.ui.components.Search
import com.masslany.justevaluateit.ui.theme.BarcodeButtonHeight
import com.masslany.justevaluateit.ui.theme.SpaceMedium
import com.masslany.justevaluateit.ui.theme.SpaceVeryLarge

@Composable
fun DashboardScreen() {
    var searchValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        AppBar(
            modifier = Modifier.padding(top = SpaceVeryLarge),
            title = {
                Text(stringResource(R.string.dashboard), style = MaterialTheme.typography.h2)
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = SpaceMedium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Search(
                modifier = Modifier
                    .padding(start = SpaceMedium, end = SpaceMedium)
                    .fillMaxWidth()
                    .weight(1f),
                value = searchValue,
                onValueChange = {
                    searchValue = it
                }
            )
            BarcodeButton(
                modifier = Modifier
                    .padding(end = SpaceMedium)
                    .height(BarcodeButtonHeight),
                onClick = {}
            )
        }

    }
}

