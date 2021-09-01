package com.masslany.justevaluateit.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.masslany.justevaluateit.presentation.ui.theme.SurfaceDarkColor
import com.masslany.justevaluateit.presentation.ui.theme.SpaceMedium
import com.masslany.justevaluateit.presentation.ui.theme.SpaceSmall

@Composable
fun RecentlyAdded(
    modifier: Modifier = Modifier,
    list: List<String> = emptyList(), // TODO: Have domain class here
    onItemClick: (String) -> Unit = {} // TODO: Here as well
) {
    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colors.surface,
                shape = RoundedCornerShape(24.dp)
            )
            .clip(RoundedCornerShape(24.dp))
    ) {
        Text(
            text = "Recently added",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(SpaceMedium)
        )
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(listOf(1, 2, 3, 4, 5, 6, 7)) { item ->
                Text(
                    "Hello $item", modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(SpaceSmall)
                )
            }
        }
    }
}