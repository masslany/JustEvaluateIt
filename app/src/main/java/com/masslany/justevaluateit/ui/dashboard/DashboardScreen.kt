package com.masslany.justevaluateit.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.masslany.justevaluateit.ui.components.BarcodeButton
import com.masslany.justevaluateit.ui.components.Search

@Composable
fun DashboardScreen() {
    var searchValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp)
            .background(MaterialTheme.colors.background)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Search(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .weight(1f),
                value = searchValue,
                onValueChange = {
                    searchValue = it
                }
            )
            BarcodeButton(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .height(48.dp),
                onClick = {}
            )
        }

    }
}

