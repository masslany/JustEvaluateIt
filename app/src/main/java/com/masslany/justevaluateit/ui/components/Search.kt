package com.masslany.justevaluateit.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.masslany.justevaluateit.R

@Composable
fun Search(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { SearchPlaceholder() },
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            shape = CircleShape,
            trailingIcon = { TrailingSearchIcon() }
        )
    }
}

@Composable
private fun SearchPlaceholder() {
    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = stringResource(R.string.search_placeholder))
    }
}

@Composable
private fun TrailingSearchIcon() {
    val icon = if (MaterialTheme.colors.isLight) {
        painterResource(id = R.drawable.ic_search_dark)
    } else {
        painterResource(id = R.drawable.ic_search_light)
    }
    Image(
        painter = icon,
        contentDescription = stringResource(R.string.content_description_search_icon)
    )
}