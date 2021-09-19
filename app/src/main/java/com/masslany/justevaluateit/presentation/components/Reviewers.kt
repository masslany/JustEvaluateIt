package com.masslany.justevaluateit.presentation.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.presentation.ui.theme.PurpleGradientBrush

data class Reviewer(val id: Int, val name: String)

@Composable
fun Reviewers(
    items: List<Reviewer>,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    var selectedItem by rememberSaveable {
        mutableStateOf(items[0].id)
    }
    Row(
        modifier = modifier
            .horizontalScroll(scrollState)
    ) {
        items.forEachIndexed { index, reviewer ->
            ReviewerItem(reviewer, index == selectedItem) { item ->
                selectedItem = item
            }
        }
    }
}

@Composable
fun ReviewerItem(reviewer: Reviewer, isSelected: Boolean, onItemSelected: (Int) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable {
                onItemSelected(reviewer.id)
            }
            .widthIn(0.dp, 100.dp)
    ) {
        Column(
            Modifier
                .size(100.dp)
                .aspectRatio(1.0f)

        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "",
                modifier = Modifier
                    .then(
                        if (isSelected) {
                            Modifier.border(5.dp, PurpleGradientBrush, CircleShape)
                        } else {
                            Modifier
                        }
                    )
            )

        }
        Text(
            text = reviewer.name,
            modifier = Modifier
                .padding(top = 16.dp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }

}
