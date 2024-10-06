package com.gwolf.freshcart.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardBackspace
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gwolf.freshcart.R
import com.gwolf.freshcart.ui.theme.robotoFontFamily

@Composable
fun BoxScope.TopAuthMenu(
    onClickBack: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 64.dp)
            .align(Alignment.TopCenter),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Icon(
            modifier = Modifier.clickable {
                onClickBack.invoke()
            },
            imageVector = Icons.AutoMirrored.Filled.KeyboardBackspace,
            contentDescription = null,
            tint = Color.White
        )
        Text(
            modifier = Modifier,
            text = stringResource(id = R.string.title_welcome),
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier)
    }
}