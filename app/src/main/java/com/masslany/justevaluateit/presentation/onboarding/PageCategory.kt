package com.masslany.justevaluateit.presentation.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.data.local.entity.Category
import com.masslany.justevaluateit.presentation.components.CategoryItem
import com.masslany.justevaluateit.presentation.components.CircleButton
import com.masslany.justevaluateit.presentation.components.InputField
import com.masslany.justevaluateit.presentation.ui.theme.SpaceMedium
import com.masslany.justevaluateit.presentation.ui.theme.SpaceVeryLarge
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun PageCategory(
    categories: List<Category>,
    addCategoryFieldValue: String,
    onAddCategoryFieldValueChange: (String) -> Unit,
    onAddCategoryButtonClicked: () -> Unit,
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
                painter = painterResource(id = R.drawable.onboarding_third_page),
                contentDescription = stringResource(id = R.string.content_description_categories_screen_image),
                modifier = Modifier.size(350.dp)
            )
            Text(stringResource(R.string.setup_categories), fontSize = 22.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.size(SpaceMedium))

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(start = SpaceMedium),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                categories.forEach { category ->
                    CategoryItem(
                        category = category,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
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
                            delay(SLIDE_TO_KEYBOARD_DELAY)
                            scrollState.scrollTo(scrollState.maxValue)
                        }
                    }
                )
                Text(stringResource(R.string.add_category), fontSize = 22.sp)
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
                        value = addCategoryFieldValue,
                        onValueChange = onAddCategoryFieldValueChange,
                        placeholder = { Text(stringResource(R.string.category_name_placeholder)) }
                    )
                    CircleButton(
                        modifier = Modifier.padding(end = SpaceMedium),
                        text = stringResource(id = R.string.add),
                        onClick = {
                            onAddCategoryButtonClicked()
                            isAddReviewerFieldVisible = false
                        }
                    )
                }
                Spacer(modifier = Modifier.size(SpaceVeryLarge))
            }
        }
    }
}
