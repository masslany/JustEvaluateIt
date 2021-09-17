package com.masslany.justevaluateit.presentation.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.data.local.entity.Reviewer
import com.masslany.justevaluateit.presentation.components.CircleButton
import com.masslany.justevaluateit.presentation.components.InputField
import com.masslany.justevaluateit.presentation.components.ReviewerItem
import com.masslany.justevaluateit.presentation.ui.theme.SpaceMedium
import com.masslany.justevaluateit.presentation.ui.theme.SpaceVeryLarge
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun PageReviewer(
    reviewers: List<Reviewer>,
    addReviewerFieldValue: String,
    onAddReviewerFieldValueChange: (String) -> Unit,
    onAddReviewerButtonClicked: () -> Unit,
) {
    var isAddReviewerFieldVisible by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
    ) {
        Spacer(Modifier.size(SpaceVeryLarge))
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                painter = painterResource(id = R.drawable.onboarding_second_page),
                contentDescription = stringResource(R.string.content_description_reviewers_screen_image),
                modifier = Modifier.size(350.dp)
            )
            Text(
                stringResource(R.string.setup_reviewers),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.size(SpaceMedium))

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(start = SpaceMedium),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                reviewers.forEach { reviewer ->
                    ReviewerItem(
                        reviewer = reviewer,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.size(SpaceMedium))
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircleButton(
                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.ic_add_light),
                    onClick = {
                        isAddReviewerFieldVisible = !isAddReviewerFieldVisible
                        scope.launch {
                            delay(200)
                            scrollState.scrollTo(scrollState.maxValue)
                        }
                    }
                )
                Text(stringResource(R.string.add_reviewer), fontSize = 22.sp)
            }

            AnimatedVisibility(isAddReviewerFieldVisible) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    InputField(
                        modifier = Modifier
                            .padding(start = SpaceMedium, end = SpaceMedium)
                            .fillMaxWidth()
                            .weight(1f),
                        value = addReviewerFieldValue,
                        onValueChange = onAddReviewerFieldValueChange,
                        placeholder = { Text(stringResource(R.string.reviewers_name_placeholder)) }
                    )
                    CircleButton(
                        modifier = Modifier.padding(end = SpaceMedium),
                        text = stringResource(R.string.add),
                        onClick = {
                            onAddReviewerButtonClicked()
                            isAddReviewerFieldVisible = false
                        })
                }
                Spacer(modifier = Modifier.size(SpaceVeryLarge))
            }

        }

    }
}