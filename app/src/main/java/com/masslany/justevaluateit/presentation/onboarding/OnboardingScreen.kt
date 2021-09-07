package com.masslany.justevaluateit.presentation.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.masslany.justevaluateit.R
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OnboardingScreen(
    onGettingStartedClick: () -> Unit,
    onSkipClicked: () -> Unit
) {
    val pagerState = rememberPagerState(pageCount = 3)
    val scope = rememberCoroutineScope()


    Column {

        HorizontalPager(
            state = pagerState,
            dragEnabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->

            when (page) {
                0 -> {
                    PageWelcome() {
                        scope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    }
                }
                1 -> {
                    PageUI(page = onboardPages[page]) {
                        scope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    }
                }
                2 -> {
                    PageUI(page = onboardPages[page]) {

                    }
                }
            }

        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = colorResource(R.color.purple_500)
        )

        AnimatedVisibility(visible = pagerState.currentPage == 2) {
            OutlinedButton(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp), onClick = onGettingStartedClick,
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = colorResource(R.color.purple_500),
                    contentColor = Color.White
                )
            ) {
                Text(text = stringResource(R.string.app_name))
            }


        }
        Spacer(modifier = Modifier.height(12.dp))
    }
}