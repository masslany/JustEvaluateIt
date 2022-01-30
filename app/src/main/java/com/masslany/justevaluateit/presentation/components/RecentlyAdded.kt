@file:Suppress("MagicNumber", "UnusedPrivateMember", "ForbiddenComment")

package com.masslany.justevaluateit.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.data.local.entity.Product
import com.masslany.justevaluateit.presentation.ui.theme.SpaceMedium
import com.masslany.justevaluateit.presentation.ui.theme.SpaceSmall

@Composable
fun RecentlyAdded(
    modifier: Modifier = Modifier,
    products: List<Product> = emptyList(),
    onItemClick: (Product) -> Unit = {}
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
            text = stringResource(R.string.recently_added),
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(SpaceMedium)
        )
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(products) { product ->
                RecentlyAddedProduct(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(SpaceSmall),
                    product = product,
                    onItemClick = onItemClick,
                )
            }
        }
    }
}

@Composable
private fun RecentlyAddedProduct(
    modifier: Modifier = Modifier,
    product: Product,
    onItemClick: (Product) -> Unit,
) {
    Row(
        modifier = modifier
            .clickable { onItemClick(product) },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = product.name, Modifier.padding(horizontal = 8.dp))
    }
}
