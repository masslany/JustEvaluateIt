package com.masslany.justevaluateit.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.common.decodeBase64IntoBitmap
import com.masslany.justevaluateit.data.local.entity.Reviewer
import com.masslany.justevaluateit.presentation.ui.theme.SpaceMedium

@Composable
fun ReviewerItem(
    reviewer: Reviewer,
    modifier: Modifier = Modifier
) {
    val bitmap = if (reviewer.photo != null) {
        reviewer.photo.decodeBase64IntoBitmap().asImageBitmap()
    } else {
        ImageBitmap.imageResource(id = R.drawable.blank_user)
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            bitmap = bitmap,
            contentDescription = "",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Text(
            text = reviewer.name,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(start = SpaceMedium)
        )
    }
}

@Preview
@Composable
fun ReviewerItemPreview(reviewer: Reviewer = Reviewer(name = "Jan", photo = null)) {
    ReviewerItem(reviewer = reviewer)
}