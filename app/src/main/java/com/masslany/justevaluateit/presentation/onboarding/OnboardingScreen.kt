package com.masslany.justevaluateit.presentation.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.data.local.entity.Category
import com.masslany.justevaluateit.data.local.entity.Reviewer
import com.masslany.justevaluateit.presentation.components.CircleButton
import com.masslany.justevaluateit.presentation.components.RoundedButton
import com.masslany.justevaluateit.presentation.ui.theme.SpaceMedium
import com.masslany.justevaluateit.presentation.ui.theme.SurfaceDarkColor
import com.masslany.justevaluateit.presentation.ui.theme.SurfaceLightColor
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel,
    navController: NavController
) {
    val reviewers by viewModel.reviewers.collectAsState(initial = emptyList())
    val addReviewerFieldState = viewModel.addReviewerFieldState.value

    val categories by viewModel.categories.collectAsState(initial = emptyList())
    val addCategoryFieldState = viewModel.addCategoryFieldState.value

    OnboardingScreen(
        onGetStartedClick = {
            viewModel.onGetStartedButtonClicked()

            navController.navigate(
                R.id.to_app_nav_graph
            )
        },
        reviewers = reviewers,
        addReviewerFieldValue = addReviewerFieldState,
        onAddReviewerFieldValueChange = viewModel::onAddReviewerFieldChange,
        onAddReviewerButtonClicked = viewModel::onAddReviewerButtonClicked,
        categories = categories,
        addCategoryFieldValue = addCategoryFieldState,
        onAddCategoryFieldValueChange = viewModel::onAddCategoryFieldChange,
        onAddCategoryButtonClicked = viewModel::onAddCategoryButtonClicked,
    )
}

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
@Suppress("LongParameterList")
fun OnboardingScreen(
    onGetStartedClick: () -> Unit,
    reviewers: List<Reviewer>,
    addReviewerFieldValue: String,
    onAddReviewerFieldValueChange: (String) -> Unit,
    onAddReviewerButtonClicked: () -> Unit,
    categories: List<Category>,
    addCategoryFieldValue: String,
    onAddCategoryFieldValueChange: (String) -> Unit,
    onAddCategoryButtonClicked: () -> Unit,
) {
    val pagerState = rememberPagerState(pageCount = 3)
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        HorizontalPager(
            state = pagerState,
            dragEnabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->

            when (page) {
                0 -> {
                    PageWelcome()
                }
                1 -> {
                    PageReviewer(
                        reviewers = reviewers,
                        addReviewerFieldValue = addReviewerFieldValue,
                        onAddReviewerFieldValueChange = onAddReviewerFieldValueChange,
                        onAddReviewerButtonClicked = onAddReviewerButtonClicked
                    )
                }
                2 -> {
                    PageCategory(
                        categories = categories,
                        addCategoryFieldValue = addCategoryFieldValue,
                        onAddCategoryFieldValueChange = onAddCategoryFieldValueChange,
                        onAddCategoryButtonClicked = onAddCategoryButtonClicked
                    )
                }
            }
        }

        val shouldShowNextPageButton = pagerState.currentPage == 0 ||
                (pagerState.currentPage == 1 && reviewers.isNotEmpty())

        val shouldShowGetStartedButton = pagerState.currentPage == 2 && categories.isNotEmpty()

        this@Column.AnimatedVisibility(
            visible = shouldShowNextPageButton
        ) {
            CircleButton(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.ic_arrow_forward_light),
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            )
        }

        this@Column.AnimatedVisibility(
            visible = shouldShowGetStartedButton
        ) {
            RoundedButton(
                modifier = Modifier,
                text = stringResource(R.string.get_started),
                onClick = {
                    onGetStartedClick()
                }
            )
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(SpaceMedium),
            inactiveColor = SurfaceDarkColor,
            activeColor = SurfaceLightColor
        )

        Spacer(modifier = Modifier.height(12.dp))
    }
}
