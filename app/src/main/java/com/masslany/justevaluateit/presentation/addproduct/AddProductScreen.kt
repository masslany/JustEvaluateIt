package com.masslany.justevaluateit.presentation.addproduct

import androidx.annotation.StringRes
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
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.data.local.entity.Category
import com.masslany.justevaluateit.presentation.addproduct.state.AddProductScreenState
import com.masslany.justevaluateit.presentation.addproduct.state.AddProductState
import com.masslany.justevaluateit.presentation.components.AppBar
import com.masslany.justevaluateit.presentation.components.BarcodeButton
import com.masslany.justevaluateit.presentation.dashboard.Tile
import com.masslany.justevaluateit.presentation.ui.theme.BarcodeButtonHeight
import com.masslany.justevaluateit.presentation.ui.theme.PurpleGradientBrush
import com.masslany.justevaluateit.presentation.ui.theme.SpaceMedium
import com.masslany.justevaluateit.presentation.ui.theme.SpaceVeryLarge


@ExperimentalComposeUiApi
@Composable
fun AddProductScreen(
    navController: NavController,
    viewModel: AddProductViewModel,
) {
    val categories by viewModel.categories.collectAsState(initial = emptyList())
    val addProductState by viewModel.addProductState.observeAsState()

    AddProductScreen(
        addProductState = addProductState,
        onNavigationIconClicked = { navController.popBackStack() },
        categories = categories,
        onCategoryChanged = viewModel::onCategoryChanged,
        onSaveProductButtonClicked = viewModel::onSaveProductButtonClicked,
    )
}

@ExperimentalComposeUiApi
@Composable
fun AddProductScreen(
    addProductState: AddProductState?,
    onNavigationIconClicked: () -> Unit,
    categories: List<Category>,
    onCategoryChanged: (Category) -> Unit,
    onSaveProductButtonClicked: (String, String, String) -> Unit,
) {
    val columnScrollState = rememberScrollState()
    val screenState by remember { mutableStateOf(AddProductScreenState()) }

    when (addProductState) {
        AddProductState.EmptyProductName ->
            screenState.showInvalidProductName(R.string.empty_product_name_error)
        AddProductState.AlreadyTakenProductName ->
            screenState.showInvalidProductName(R.string.product_name_exists_error)
        AddProductState.InvalidBarcode -> screenState.showInvalidBarcode()
//        AddProductState.Valid -> onValidProduct()
        else -> {
            /* No interaction */
        }
    }

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
                Column(
                    modifier = Modifier
                        .padding(top = SpaceMedium)
                ) {
                    ProductNameField(
                        modifier = Modifier
                            .padding(end = SpaceMedium),
                        value = screenState.productName,
                        onValueChange = screenState::onProductNameFieldChange,
                        isError = screenState.isInvalidName,
                        errorMessage = screenState.productErrorMessage
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ProductBarcodeField(
                            modifier = Modifier
                                .padding(top = SpaceMedium, end = SpaceMedium)
                                .weight(1f),
                            value = screenState.barcode,
                            onValueChange = screenState::onBarcodeFieldChange,
                            isError = screenState.isInvalidBarcode
                        )

                        val barcodeTopPadding =
                            if (screenState.isInvalidBarcode) SpaceVeryLarge else SpaceMedium
                        BarcodeButton(
                            modifier = Modifier
                                .padding(top = barcodeTopPadding, end = SpaceMedium)
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
                    end = SpaceMedium
                ),
                items = categories,
                onCategorySelected = onCategoryChanged,
            )

            DescriptionField(
                modifier = Modifier.padding(
                    start = SpaceMedium,
                    top = SpaceMedium,
                    end = SpaceMedium
                ),
                value = screenState.description,
                onValueChange = screenState::onDescriptionFieldChange,
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
            screenState.resetUiState()
            onSaveProductButtonClicked(
                screenState.productName,
                screenState.barcode,
                screenState.description
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
private fun ProductNameField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean,
    @StringRes errorMessage: Int
) {
    Column(modifier = modifier) {
        if (isError) {
            Text(
                stringResource(errorMessage),
                color = Color.Red,
                fontSize = 12.sp
            )
        }
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
            maxLines = 1,
            singleLine = true,
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
    isError: Boolean
) {
    Column(modifier = modifier) {
        if (isError) {
            Text(
                stringResource(R.string.invalid_barcode_error),
                color = Color.Red,
                fontSize = 12.sp
            )
        }
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
            ),
            maxLines = 1,
            singleLine = true,
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
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
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
    items: List<Category>,
    onCategorySelected: (Category) -> Unit,
) {
    if (items.isEmpty())
        return

    val text = rememberSaveable { mutableStateOf(items[0].name) }
    /**
     * Propagate default value further up on the first composition
     * Might thinks about reworking that later on
     **/
    if (text.value == items[0].name) {
        onCategorySelected(items[0])
    }
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
            CategoryField(value = text.value, onValueChange = { text.value = it })
        }

        DropDownList(
            modifier = Modifier,
//                .padding(start = SpaceMedium, end = SpaceMedium)
//                .fillMaxWidth(),
            requestToOpen = isOpen.value,
            list = items,
            openCloseOfDropDownList,
            selectedItem = {
                onCategorySelected(it)
                text.value = it.name
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
    list: List<Category>,
    request: (Boolean) -> Unit,
    selectedItem: (Category) -> Unit
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
                    selectedItem(item)
                }
            ) {
                Text(
                    item.name,
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




