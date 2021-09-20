package com.masslany.justevaluateit.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masslany.justevaluateit.R

@Composable
fun PageWelcome() {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {

            Image(
                painter = painterResource(id = R.drawable.onboarding_first_page),
                contentDescription = stringResource(R.string.content_description_welcome_screen_image),
                modifier = Modifier.size(350.dp)
            )
            Text(stringResource(R.string.welcome_to_app_name), fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(stringResource(R.string.welcome_additional_text))
        }
    }
}
