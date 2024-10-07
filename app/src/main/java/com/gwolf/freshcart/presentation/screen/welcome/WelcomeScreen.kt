package com.gwolf.freshcart.presentation.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gwolf.freshcart.R
import com.gwolf.freshcart.navigation.Screen
import com.gwolf.freshcart.presentation.component.CustomButton
import com.gwolf.freshcart.ui.theme.PrimaryDarkColor
import com.gwolf.freshcart.ui.theme.robotoFontFamily
import kotlinx.coroutines.launch

@Composable
fun WelcomeScreen(
    navController: NavController,
    viewModel: WelcomeViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third,
        OnBoardingPage.Fourth
    )
    val pagerState = rememberPagerState(
        pageCount = { pages.size }
    )
    Box {
        HorizontalPager(
            state = pagerState
        ) {position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 56.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            PagerIndicator(pagerState)
            val btnText = if(pagerState.currentPage == pagerState.pageCount.dec()) R.string.title_start else R.string.title_next
            val coroutineScope = rememberCoroutineScope()
            CustomButton(
                text = btnText
            ) {
                if(pagerState.canScrollForward) {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.targetPage.inc())
                    }
                } else {
                    navigateToAuth(
                        viewModel = viewModel,
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
private fun PagerIndicator(
    pagerState: PagerState
) {
    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(bottom = 32.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color =
                if (pagerState.currentPage == iteration) PrimaryDarkColor else Color.White
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(8.dp)
            )
        }
    }
}

@Composable
private fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp, vertical = 56.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 40.dp),
                text = stringResource(id = onBoardingPage.title),
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            if(onBoardingPage.icon != 0) {
                Spacer(modifier = Modifier.size(12.dp))
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .scale(1.5f),
                    painter = painterResource(id = onBoardingPage.icon),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                modifier = Modifier,
                text = stringResource(id = onBoardingPage.description),
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

private fun navigateToAuth(
    viewModel: WelcomeViewModel,
    navController: NavController
) {
    viewModel.saveOnBoarding(completed = true)
    navController.navigate(Screen.Auth)
}

@Preview(showBackground = true)
@Composable
private fun FirstPagerScreenPreview() {
    PagerScreen(OnBoardingPage.First)
}

@Preview(showBackground = true)
@Composable
private fun SecondPagerScreenPreview() {
    PagerScreen(OnBoardingPage.Second)
}

@Preview(showBackground = true)
@Composable
private fun ThirdPagerScreenPreview() {
    PagerScreen(OnBoardingPage.Third)
}

@Preview(showBackground = true)
@Composable
private fun FourthPagerScreenPreview() {
    PagerScreen(OnBoardingPage.Fourth)
}