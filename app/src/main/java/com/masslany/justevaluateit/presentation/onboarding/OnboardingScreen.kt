package com.masslany.justevaluateit.presentation.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.data.local.entity.Reviewer
import com.masslany.justevaluateit.presentation.components.CircleButton
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
    val reviewers = viewModel.reviewers.value
    val addReviewerFieldState = viewModel.addReviewerFieldState.value

    OnboardingScreen(
        onGettingStartedClick = {
            navController.navigate(R.id.action_onboardingFragment_to_dashboardFragment)
        },
        reviewers = reviewers,
        addReviewerFieldValue = addReviewerFieldState,
        onAddReviewerFieldValueChange = viewModel::onAddReviewerFieldChange,
        onAddReviewerButtonClicked = viewModel::onAddReviewerButtonClicked
    )
}

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OnboardingScreen(
    onGettingStartedClick: () -> Unit,
    reviewers: List<Reviewer>,
    addReviewerFieldValue: String,
    onAddReviewerFieldValueChange: (String) -> Unit,
    onAddReviewerButtonClicked: () -> Unit,
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
                        onNextPageButtonPressed = {
                            scope.launch {
                                pagerState.animateScrollToPage(page + 1)
                            }
                        },
                        onAddReviewerButtonClicked = onAddReviewerButtonClicked
                    )


                }
                2 -> {
//                    PageReviewer(
//
//                        addReviewerFieldValue = "",
//                        onAddReviewerFieldValueChange = {},
//                        onNextPageButtonPressed = {
//                            scope.launch {
//                                pagerState.animateScrollToPage(page + 1)
//                            }
//                        },
//                        onAddReviewerButtonClicked = onAddReviewerButtonClicked
//                    )
                }
            }

        }

        val shouldShowNextPageButton = pagerState.currentPage == 0 || reviewers.isNotEmpty()

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

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            inactiveColor = SurfaceDarkColor,
            activeColor = SurfaceLightColor
        )


        Spacer(modifier = Modifier.height(12.dp))
    }
}