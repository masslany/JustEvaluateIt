package com.masslany.justevaluateit.presentation.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.data.local.entity.Reviewer
import com.masslany.justevaluateit.presentation.components.CircleButton
import com.masslany.justevaluateit.presentation.components.ReviewerItem
import com.masslany.justevaluateit.presentation.ui.theme.SpaceMedium
import com.masslany.justevaluateit.presentation.ui.theme.SpaceVeryLarge

@ExperimentalAnimationApi
@Composable
fun PageReviewer(
    reviewers: List<Reviewer> = emptyList(),
    onNextPageButtonPressed: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Spacer(Modifier.size(SpaceVeryLarge))

        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.onboarding_first_page),
                contentDescription = "",
                modifier = Modifier.size(350.dp)
            )
            Text("Setup reviewers", fontSize = 22.sp, fontWeight = FontWeight.Bold)

            Column(Modifier.fillMaxWidth()) {
                reviewers.forEach { reviewer ->
                    ReviewerItem(reviewer)
                    Spacer(Modifier.size(SpaceMedium))
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CircleButton(
                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.ic_add_light),
                    onClick = {}
                )
                Text("Add reviewer", fontSize = 22.sp)
            }


        }

        AnimatedVisibility(visible = reviewers.isNotEmpty()) {
            CircleButton(
                modifier = Modifier
                    .align(Alignment.BottomCenter),
                painter = painterResource(id = R.drawable.ic_arrow_forward_light),
                onClick = onNextPageButtonPressed
            )
        }
    }

}