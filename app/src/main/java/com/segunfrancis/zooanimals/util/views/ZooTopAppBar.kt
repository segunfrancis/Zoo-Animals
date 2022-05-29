package com.segunfrancis.zooanimals.util.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.segunfrancis.zooanimals.R

@Composable
fun ZooTopAppBar(
    title: String,
    showBackIcon: Boolean = false,
    onBackIconClick: (() -> Unit)? = null
) {
    TopAppBar(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 2.dp,
        contentPadding = PaddingValues(4.dp)
    ) {
        AnimatedVisibility(
            visible = showBackIcon,
            enter = fadeIn(initialAlpha = 0.4F),
            exit = fadeOut(animationSpec = tween(durationMillis = 250))
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "Back button",
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onPrimary),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(24.dp)
                    .clickable { onBackIconClick?.invoke() }
            )
        }
        Text(
            text = title,
            style = TextStyle(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(horizontal = 4.dp),
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ZooTopAppBarPreview() {
    ZooTopAppBar(title = "Zoo Animals")
}
