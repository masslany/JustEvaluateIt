package com.masslany.justevaluateit.presentation.addproduct

import androidx.compose.foundation.layout.*
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
import com.masslany.justevaluateit.presentation.components.AppBar
import com.masslany.justevaluateit.presentation.components.BackNavigationIcon
import com.masslany.justevaluateit.presentation.dashboard.Tile
import com.masslany.justevaluateit.presentation.ui.theme.SpaceMedium
import com.masslany.justevaluateit.presentation.ui.theme.SpaceVeryLarge

@Composable
fun AddProductScreen(
    onNavigationIconClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AppBar(
//            modifier = Modifier.padding(top = SpaceVeryLarge),
            title = {
                Text(stringResource(R.string.add_product), style = MaterialTheme.typography.h2)
            },
            showNavigationIcon = true,
            onNavigationIconClicked = {
                onNavigationIconClicked()
            }
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Tile(
                modifier = Modifier
                    .padding(SpaceMedium)
                    .fillMaxWidth(0.4f),
                icon = addPhotoIcon(),
                contentDescription = stringResource(R.string.content_description_add_product_tile),
            ) {

            }
            ProductName(
                modifier = Modifier
                    .padding(top = SpaceMedium, end = SpaceMedium),
                value = "",
                onValueChange = {}
            )
        }

    }
}

@Composable
private fun addPhotoIcon() = if (MaterialTheme.colors.isLight) {
    painterResource(id = R.drawable.ic_add_photo_dark)
} else {
    painterResource(id = R.drawable.ic_add_photo_light)
}

@Composable
private fun ProductName(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { NamePlaceholder() },
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            shape = CircleShape,
        )
    }
}

@Composable
private fun NamePlaceholder() {
    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = stringResource(R.string.product_name_placeholder))
    }
}