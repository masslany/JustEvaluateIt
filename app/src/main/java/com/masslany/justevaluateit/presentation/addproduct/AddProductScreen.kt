package com.masslany.justevaluateit.presentation.addproduct

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.presentation.components.AppBar
import com.masslany.justevaluateit.presentation.components.BarcodeButton
import com.masslany.justevaluateit.presentation.dashboard.Tile
import com.masslany.justevaluateit.presentation.ui.theme.BarcodeButtonHeight
import com.masslany.justevaluateit.presentation.ui.theme.SpaceMedium

@ExperimentalComposeUiApi
@Composable
fun AddProductScreen(
    onNavigationIconClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AppBar(
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
            Column {
                ProductNameField(
                    modifier = Modifier
                        .padding(top = SpaceMedium, end = SpaceMedium),
                    value = "",
                    onValueChange = {}
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ProductBarcodeField(
                        modifier = Modifier
                            .padding(top = SpaceMedium, end = SpaceMedium)
                            .weight(1f),
                        value = "",
                        onValueChange = {}
                    )
                    BarcodeButton(
                        modifier = Modifier
                            .padding(top = SpaceMedium)
                            .height(BarcodeButtonHeight)
                            .aspectRatio(1f),
                    ) {

                    }
                }
            }

        }

        Row {
            var rating by remember { mutableStateOf(8.0f) }
            RatingBar(
                value = rating,
                onValueChange = {
                    rating = it
                },
                numStars = 10,
                onRatingChanged = {},
//                modifier = Modifier.weight(1f, true)
            )
            Rating(value = "", onValueChange = {}, modifier = Modifier.weight(1.0f, true))
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
private fun ProductNameField(
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

@Composable
private fun Rating(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        TextField(
            value = value,
            onValueChange = onValueChange,
//            modifier = Modifier.fillMaxWidth(0.2f),
            placeholder = { RatingPlaceholder() },
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            shape = CircleShape,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
    }
}

@Composable
private fun RatingPlaceholder() {
    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = stringResource(R.string.rating_placeholder), overflow = TextOverflow.Ellipsis)
    }
}

@Composable
private fun ProductBarcodeField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { BarcodePlaceholder() },
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            shape = CircleShape,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
    }
}

@Composable
private fun BarcodePlaceholder() {
    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = stringResource(R.string.barcode_placeholder))
    }
}


