package com.masslany.justevaluateit.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.presentation.ui.theme.Purple200
import com.masslany.justevaluateit.presentation.ui.theme.SpaceMedium
import com.masslany.justevaluateit.presentation.ui.theme.SurfaceDarkColor

@Composable
fun PageWelcome(onNextPageButtonPressed: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {

            Image(
                painter = painterResource(id = R.drawable.onboarding_first_page),
                contentDescription = "",
                modifier = Modifier.size(350.dp)
            )
            Text("Welcome to Just Evaluate It", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text("We need to setup few things first")


        }
        Box(
            modifier = Modifier
                .padding(SpaceMedium)
                .height(80.dp)
                .aspectRatio(1.0f)
                .clip(CircleShape)
                .background(color = SurfaceDarkColor, shape = CircleShape)
                .clickable {
                    onNextPageButtonPressed()
                }
                .align(Alignment.BottomCenter)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_forward_light),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(40.dp)
            )
        }
    }

}