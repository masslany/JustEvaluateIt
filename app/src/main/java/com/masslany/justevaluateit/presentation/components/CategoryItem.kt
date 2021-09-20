package com.masslany.justevaluateit.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.masslany.justevaluateit.data.local.entity.Category
import com.masslany.justevaluateit.presentation.ui.theme.SpaceMedium

@Composable
fun CategoryItem(
    category: Category,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = category.name,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(start = SpaceMedium)
        )
    }
}

@Preview
@Composable
fun CategoryItemPreview(category: Category = Category(name = "Food")) {
    CategoryItem(category = category)
}
