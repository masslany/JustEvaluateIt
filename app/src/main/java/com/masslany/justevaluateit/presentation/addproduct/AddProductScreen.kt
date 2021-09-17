package com.masslany.justevaluateit.presentation.addproduct

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.presentation.components.AppBar
import com.masslany.justevaluateit.presentation.components.BarcodeButton
import com.masslany.justevaluateit.presentation.dashboard.Tile
import com.masslany.justevaluateit.presentation.ui.theme.BarcodeButtonHeight
import com.masslany.justevaluateit.presentation.ui.theme.PurpleGradientBrush
import com.masslany.justevaluateit.presentation.ui.theme.SpaceMedium

@ExperimentalComposeUiApi
@Composable
fun AddProductScreen(
    onNavigationIconClicked: () -> Unit
) {
    val columnScrollState = rememberScrollState()
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(columnScrollState)
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
                                .padding(top = SpaceMedium, end = SpaceMedium)
                                .height(BarcodeButtonHeight)
                                .aspectRatio(1f),
                        ) {

                        }
                    }
                }

            }

            CategorySpinner(
                modifier = Modifier.padding(
                    start = SpaceMedium,
                    top = SpaceMedium,
                    end = SpaceMedium
                ),
                items = listOf("Food", "Drink", "Games"),
            ) {

            }

            var description by remember {
                mutableStateOf("")
            }
            DescriptionField(
                modifier = Modifier.padding(
                    start = SpaceMedium,
                    top = SpaceMedium,
                    end = SpaceMedium
                ),
                value = description,
                onValueChange = { description = it }
            )

            // Space for save button
            Spacer(modifier = Modifier.size(48.dp))
        }
        SaveProductButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SpaceMedium)
                .height(45.dp)
                .align(Alignment.BottomCenter)
        ) {

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

@Composable
private fun DescriptionField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth().height(200.dp),
            placeholder = { DescriptionPlaceholder() },
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(25.dp),
            maxLines = 10,
            singleLine = false,
        )
    }
}

@Composable
private fun DescriptionPlaceholder() {
    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = stringResource(R.string.description_placeholder))
    }
}

@Composable
fun CategorySpinner(
    modifier: Modifier,
    items: List<String>,
    onTitleSelected: (String) -> Unit
) {
    val allItems = listOf(
        "All categories"
    ) + items
    val text = rememberSaveable { mutableStateOf(allItems[0]) }
    val isOpen = rememberSaveable { mutableStateOf(false) }
    val openCloseOfDropDownList: (Boolean) -> Unit = {
        isOpen.value = it
    }

    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(25.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CategoryField(value = text.value, onValueChange = { onTitleSelected(it) })
        }

        DropDownList(
            modifier = modifier,
            requestToOpen = isOpen.value,
            list = allItems,
            openCloseOfDropDownList,
            selectedString = {
                onTitleSelected(it)
                text.value = it
            }
        )

        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Transparent)
                .clickable(
                    onClick = { isOpen.value = true }
                )
        )
    }
}

@Composable
fun DropDownList(
    modifier: Modifier,
    requestToOpen: Boolean = false,
    list: List<String>,
    request: (Boolean) -> Unit,
    selectedString: (String) -> Unit
) {
    DropdownMenu(
        modifier = modifier,
        expanded = requestToOpen,
        onDismissRequest = { request(false) },
    ) {
        list.forEach { item ->
            DropdownMenuItem(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    request(false)
                    selectedString(item)
                }
            ) {
                Text(
                    item,
                    modifier = Modifier.wrapContentWidth()
                )
            }
        }
    }
}

@Composable
private fun CategoryField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
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
fun SaveProductButton(
    modifier: Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .background(brush = PurpleGradientBrush, shape = CircleShape)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Save")
    }
}


